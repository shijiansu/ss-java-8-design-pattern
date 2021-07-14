package design.pattern.by.jpsoroulas._3_beharioral._5_command;

import design.pattern.by.jpsoroulas.AbstractTest;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.HiringStrategyTestDataGenerator;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.ContactInfo;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class CommandTest extends AbstractTest {

  public Runnable non_lambda_create_command(ContactInfo contactInfo, MessageData msgData) {
    return contactInfo.isEmail()
        ? new CommandOfEmail(new DispatcherOfEmail(), msgData)
        : new CommandOfSMS(new DispatcherOfSMS(), msgData);
  }

  public Runnable lambda_create_command(ContactInfo contactInfo, MessageData msgData) {
    return contactInfo.isEmail()
        ? () -> new DispatcherOfEmail().send(msgData.getMessage(), msgData.getRecipients())
        : () -> new DispatcherOfSMS().send(msgData.getMessage(), msgData.getRecipients());
  }

  public Runnable lambda_create_command_2(ContactInfo contactInfo, MessageData msgData) {
    Supplier<MessageDispatcher> supplier = contactInfo.isEmail() ?
        DispatcherOfEmail::new : DispatcherOfSMS::new;
    return () -> supplier.get().send(msgData.getMessage(), msgData.getRecipients());
  }

  public Runnable lambda_create_command_3(ContactInfo contactInfo, MessageData msgData) {
    Function<ContactInfo, Supplier<MessageDispatcher>> function = c -> c.isEmail() ?
        (DispatcherOfEmail::new) : (DispatcherOfSMS::new);
    return () -> function.apply(contactInfo).get()
        .send(msgData.getMessage(), msgData.getRecipients());
  }

  public Runnable lambda_create_command_4(ContactInfo contactInfo, MessageData msgData) {
    Function<ContactInfo, Runnable> function = c -> () ->
        (c.isEmail() ? new DispatcherOfEmail() : new DispatcherOfSMS())
            .send(msgData.getMessage(), msgData.getRecipients());
    return function.apply(contactInfo);
  }

  @Test
  public void send_evaluation_results_messages() {
    /*This is the client, creates the concrete commands and inject the receivers.
     * Creates the invoker and bind the appropriate commands */
    // Lets assume that 10 is the number of secretaries
    int secretaries = 10;
    /* Create the 'invoker', this is the secretarial services supervisor in our domain model.
     * The 'request' (send a message to inform the candidate about the evaluation result)
     * is passed to the 'command' via the invoker's submit method */
    // new thread pool
    ExecutorService executor = Executors.newFixedThreadPool(secretaries);
    /* Create the 'receivers'. Assume that is thread safe, so a single instance
     * can be used for the respective commands */
    String message = "Dear %s here is the results of the evaluation process blah, blah, blah, ...";
    /* Create the candidates, the same number as secretaries */
    List<Candidate> candidates = HiringStrategyTestDataGenerator.buildCandidates(secretaries);
    candidates.stream()
        .filter(c -> c.getContactInfo() != null)
        .map(
            /* Map each candidate with the future returned by the task submission to the executor */
            c -> {
              ContactInfo contactInfo = c.getContactInfo();
              MessageData msgData = new MessageData(
                  String.format(message, c.getName()),
                  contactInfo.getContact());
              // Runnable command = createCommand(contactInfo, msgData); // non lambda
              Runnable command = lambda_create_command_4(contactInfo, msgData); // lambda
              /* Bind the commands to the invoker and forward the request to the command */
              // execute thread
              return executor.submit(command); // return Future
            })
        /* Do not forget to collect all the futures first and then 'query' them to retrieve the result.
         * Otherwise the tasks are executed sequentially since each task submission
         * is followed by the query to the returned 'future' that blocks the whole stream processing
         * In case you want to query the future immediately after the task submission, you can have
         * a minor performance improvement if you use parallel stream. Using parallel stream,
         * the processed stream's elements in parallel are as many as the CPU cores of your desktop machine */
        .collect(Collectors.toList())
        .forEach(
            /* Check if the all commands are completed successfully, otherwise exceptions are raised */
            future -> {
              try {
                future.get(20, TimeUnit.SECONDS); // get value in Future
              } catch (Exception ex) {
                throw new RuntimeException(ex);
              }
            });
    /* Shutdown executor service */
    VariousUtils.shutdownExecutorService(executor, 20);
  }

  @Test
  public void send_evaluation_results_messages_by_me() {
    String message = "Dear %s here is the results of the evaluation process blah, blah, blah, ...";
    HiringStrategyTestDataGenerator.buildCandidates(10)
        .stream()
        .filter(c -> c.getContactInfo() != null)
        .map(c -> {
          ContactInfo ci = c.getContactInfo();
          MessageData m = new MessageData(String.format(message, c.getName()), ci.getContact());
          Function<ContactInfo, Runnable> getCommand = ci2 -> () ->
              (ci2.isEmail() ? new DispatcherOfEmail() : new DispatcherOfSMS())
                  .send(m.getMessage(), m.getRecipients());
          return getCommand.apply(ci);
        })
        .forEach(Runnable::run);
  }
}
