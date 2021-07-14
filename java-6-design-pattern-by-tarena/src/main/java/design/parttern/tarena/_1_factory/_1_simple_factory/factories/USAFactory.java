package design.parttern.tarena._1_factory._1_simple_factory.factories;

import design.parttern.tarena._1_factory._1_simple_factory.drivers.USADriver;

public class USAFactory {
  public static USADriver createDriver() {
    USADriver driver = new USADriver("China", 100);
    return driver;
  }
}
