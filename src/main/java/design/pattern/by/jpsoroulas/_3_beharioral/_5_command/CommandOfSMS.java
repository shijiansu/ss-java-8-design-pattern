package design.pattern.by.jpsoroulas._3_beharioral._5_command;

public class CommandOfSMS implements Runnable {

  private MessageDispatcher dispatcher;

  private MessageData messageData;

  public CommandOfSMS(MessageDispatcher dispatcher, MessageData messageData) {
    this.dispatcher = dispatcher;
    this.messageData = messageData;
  }

  @Override
  public void run() {
    dispatcher.send(messageData.getMessage(), messageData.getRecipients());
  }

}
