package design.pattern.by.jpsoroulas._3_beharioral._5_command;

public class MessageData {

  private String[] recipients;

  private String message;

  public MessageData(String message, String... recipients) {
    this.message = message;
    this.recipients = recipients;
  }

  public String getMessage() {
    return message;
  }

  public String[] getRecipients() {
    return recipients;
  }

}
