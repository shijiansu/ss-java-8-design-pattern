package design.pattern.by.jpsoroulas._3_beharioral._5_command;

import java.util.Arrays;
import org.apache.commons.lang3.Validate;

public abstract class MessageDispatcher {

  public void send(String message, String... recipients) {
    Validate.notNull(message, "Undefined message!");
    Validate.notEmpty(recipients, "At least one recipient should be specified");
    Arrays.stream(recipients).forEach(Validate::notBlank);
    // Call the actual functionality
    doSend(message, recipients);
  }

  protected abstract void doSend(String message, String... recipients);
}
