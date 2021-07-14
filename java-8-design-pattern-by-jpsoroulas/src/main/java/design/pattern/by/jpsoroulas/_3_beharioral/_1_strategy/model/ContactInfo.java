package design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model;

import lombok.Data;
import org.apache.commons.lang3.Validate;

@Data
public class ContactInfo {

  private String contact;

  private boolean email;

  public ContactInfo(String contact, boolean email) {
    Validate.notBlank("Undefined contact!");
    this.contact = contact;
    this.email = email;
  }
}
