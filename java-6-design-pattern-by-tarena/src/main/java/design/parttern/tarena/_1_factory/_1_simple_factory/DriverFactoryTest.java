package design.parttern.tarena._1_factory._1_simple_factory;

import design.parttern.tarena._1_factory._1_simple_factory.drivers.ChineseDriver;
import design.parttern.tarena._1_factory._1_simple_factory.drivers.HanGuoDriver;
import design.parttern.tarena._1_factory._1_simple_factory.drivers.USADriver;

public class DriverFactoryTest {

  public static void main(String[] args) {
    ChineseDriver driver = (ChineseDriver) DriverFactory.getDriver("CHINA");
    driver.printMe();

    USADriver driver2 = (USADriver) DriverFactory.getDriver("USA");
    driver2.printMe();

    HanGuoDriver driver3 = (HanGuoDriver) DriverFactory.getDriver("HANGUO");
    driver3.printMe();
  }
}
