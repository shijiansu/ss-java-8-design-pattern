package design.pattern.by.jpsoroulas._3_beharioral._4_chain;

import lombok.Data;

@Data
public class ItSupportRequest {

  private RequestType type;
  private boolean handled = false;

  public ItSupportRequest() {
    this.type = RequestType.LEVEL1;
  }

  ItSupportRequest(RequestType type) {
    this.type = type;
  }

  public enum RequestType {
    LEVEL1, LEVEL2, LEVEL3, LEVEL4
  }

}
