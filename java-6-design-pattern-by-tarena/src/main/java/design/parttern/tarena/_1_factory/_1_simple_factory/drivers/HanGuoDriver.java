package design.parttern.tarena._1_factory._1_simple_factory.drivers;

public class HanGuoDriver {
  public int point;

  public HanGuoDriver(int point) {
    this.point = point;
  }

  public void printMe() {
    System.out.println("我不是日本货！");
  }
}
