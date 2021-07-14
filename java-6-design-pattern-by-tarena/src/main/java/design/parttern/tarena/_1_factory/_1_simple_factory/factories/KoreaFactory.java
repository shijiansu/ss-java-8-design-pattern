package design.parttern.tarena._1_factory._1_simple_factory.factories;

import design.parttern.tarena._1_factory._1_simple_factory.drivers.HanGuoDriver;

public class KoreaFactory {
  public static HanGuoDriver createDriver() {
    HanGuoDriver driver = new HanGuoDriver(100);
    return driver;
  }
}
