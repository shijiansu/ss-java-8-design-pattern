package design.parttern.tarena._1_factory._1_simple_factory.drivers;

public class ChineseDriver {
  public String nation;

  public ChineseDriver(String nation) {
    this.nation = nation;
  }

  public void printMe() {
    System.out.println("还是国产货好啊！");
  }
}
