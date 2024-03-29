package design.pattern.by.jpsoroulas._3_beharioral._4_chain;

public class ItSupportOf2ndLevel extends ItSupport {

  ItSupportOf2ndLevel() {
  }

  ItSupportOf2ndLevel(ItSupport nextSupport) {
    super(nextSupport);
  }

  @Override
  public ItSupportRequest doHandle(ItSupportRequest request) {
    return ItSupportHandlerAlgorithms.secondLevelSupport(request);
  }

}
