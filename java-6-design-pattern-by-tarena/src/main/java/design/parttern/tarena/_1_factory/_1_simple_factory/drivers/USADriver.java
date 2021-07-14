package design.parttern.tarena._1_factory._1_simple_factory.drivers;

public class USADriver {
  public String nation;
  public int point;

  public USADriver(String nation, int point) {
    this.nation = nation;
    this.point = point;
  }

  public void printMe() {
    System.out.println("I come from USA��");
  }
}
