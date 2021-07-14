package design.parttern.tarena._1_factory._1_simple_factory.factories;

import design.parttern.tarena._1_factory._1_simple_factory.drivers.ChineseDriver;

public class ChineseFactory {
  public static ChineseDriver createDriver() {
    ChineseDriver driver = new ChineseDriver("China");
    return driver;
  }
}
