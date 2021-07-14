package design.parttern.tarena._1_factory._2_static_factory;

import design.parttern.tarena._1_factory._2_static_factory.CarFactory.Car;

public class FactoryTest {
  public static void main(String[] args) {
    Car car = CarFactory.getCar(0);
    car.run();
  }
}
