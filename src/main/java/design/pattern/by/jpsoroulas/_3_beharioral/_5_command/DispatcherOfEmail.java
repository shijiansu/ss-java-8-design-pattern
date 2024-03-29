package design.pattern.by.jpsoroulas._3_beharioral._5_command;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DispatcherOfEmail extends MessageDispatcher {

  @Override
  public void doSend(String message, String... recipients) {
    Arrays.stream(recipients).forEach(recipient -> {
      log.info("Sending email to {}, : {}", recipient, message);
      VariousUtils.keepBusy(TimeUnit.MILLISECONDS, 10);
    });
  }
}
