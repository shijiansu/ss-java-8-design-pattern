package design.pattern.by.jpsoroulas._3_beharioral._4_chain;

public class ItSupportOf3rdLevel extends ItSupport {

  ItSupportOf3rdLevel() {
  }

  ItSupportOf3rdLevel(ItSupport nextSupport) {
    super(nextSupport);
  }

  @Override
  public ItSupportRequest doHandle(ItSupportRequest request) {
    return ItSupportHandlerAlgorithms.thirdLevelSupport(request);
  }

}
