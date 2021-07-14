package design.parttern.tarena._1_factory._2_static_factory;

// 工厂类
class CarFactory {
  // 工厂方法
  // 代码在增加车无关系
  public static Car getCar(int x) {
    if (x == 0) {
      return new BMW();
    } else if (x == 1) {
      return new Benz();
    } else if (x == 2) {
      return new QQ();
    } else {
      return new Car();
    }
  }

  // 产品类
  static class Car {
    public void run() {
      System.out.println("Running ...");
    }
  }

  // 具体的产品类
  static class BMW extends Car {}

  static class Benz extends Car {}

  static class QQ extends Car {}
}
