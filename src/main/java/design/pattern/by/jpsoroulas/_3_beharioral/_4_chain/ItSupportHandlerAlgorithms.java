package design.pattern.by.jpsoroulas._3_beharioral._4_chain;

import design.pattern.by.jpsoroulas._3_beharioral._4_chain.ItSupportRequest.RequestType;

public interface ItSupportHandlerAlgorithms {

  static ItSupportRequest firstLevelSupport(ItSupportRequest request) {
    // Set it as handled if only request 1st level - terminate the process
    if (RequestType.LEVEL1 == request.getType()) {
      request.setHandled(true);
    }
    return request;
  }

  static ItSupportRequest secondLevelSupport(ItSupportRequest request) {
    // Set it as handled if only request 2nd level - terminate the process
    if (RequestType.LEVEL2 == request.getType()) {
      request.setHandled(true);
    }
    return request;
  }

  static ItSupportRequest thirdLevelSupport(ItSupportRequest request) {
    // Set it as handled if only request 3rd level - terminate the process
    if (RequestType.LEVEL3 == request.getType()) {
      request.setHandled(true);
    }
    return request;
  }

}
