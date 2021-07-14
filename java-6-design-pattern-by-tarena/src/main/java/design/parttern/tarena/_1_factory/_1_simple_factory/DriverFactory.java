package design.parttern.tarena._1_factory._1_simple_factory;

import design.parttern.tarena._1_factory._1_simple_factory.factories.ChineseFactory;
import design.parttern.tarena._1_factory._1_simple_factory.factories.KoreaFactory;
import design.parttern.tarena._1_factory._1_simple_factory.factories.USAFactory;

public class DriverFactory {
  public static Object getDriver(String driverName) {
    Object driver = null;

    if (true == driverName.equals("CHINA")) {
      driver = ChineseFactory.createDriver();
    } else if (true == driverName.equals("USA")) {
      driver = USAFactory.createDriver();
    } else if (true == driverName.equals("HANGUO")) {
      driver = KoreaFactory.createDriver();
    }

    return driver;
  }
}
