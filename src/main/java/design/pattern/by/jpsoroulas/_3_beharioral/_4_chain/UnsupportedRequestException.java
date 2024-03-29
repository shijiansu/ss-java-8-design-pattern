package design.pattern.by.jpsoroulas._3_beharioral._4_chain;

public class UnsupportedRequestException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  UnsupportedRequestException(String message) {
    super(message);
  }

}
