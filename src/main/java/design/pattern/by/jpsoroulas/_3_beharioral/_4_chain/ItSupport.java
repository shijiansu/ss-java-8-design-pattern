package design.pattern.by.jpsoroulas._3_beharioral._4_chain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;

@Slf4j
public abstract class ItSupport {

  private ItSupport nextSupport;

  ItSupport() {
  }

  ItSupport(ItSupport nextSupport) {
    this.nextSupport = nextSupport;
  }

  ItSupportRequest handle(ItSupportRequest request) {
    Validate.notNull(request, "Support request is required!");
    request = doHandle(request);
    if (request.isHandled()) {
      log.info("Request type {} handled by {}", request.getType(), getClass().getSimpleName());
      return request;
    } else {
      if (null != nextSupport) {
        return nextSupport.handle(request); // by recursion
      }
      throw new UnsupportedRequestException(request.getType().toString());
    }
  }

  ItSupport getNextSupport() {
    return nextSupport;
  }

  void setNextSupport(ItSupport nextSupport) {
    this.nextSupport = nextSupport;
  }

  // to customizing process
  protected abstract ItSupportRequest doHandle(ItSupportRequest request);

}
