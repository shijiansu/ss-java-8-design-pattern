package design.pattern.by.jpsoroulas._3_beharioral._4_chain;

public class ItSupportOf1stLevel extends ItSupport {

  ItSupportOf1stLevel() {
  }

  ItSupportOf1stLevel(ItSupport nextSupport) {
    super(nextSupport);
  }

  @Override
  public ItSupportRequest doHandle(ItSupportRequest request) {
    return ItSupportHandlerAlgorithms.firstLevelSupport(request);
  }

}
