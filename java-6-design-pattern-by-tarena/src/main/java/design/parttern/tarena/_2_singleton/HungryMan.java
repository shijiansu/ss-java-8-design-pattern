package design.parttern.tarena._2_singleton;

public class HungryMan { // 饿汉模式
  // 构造方法私有
  private HungryMan() {}

  // 实例化一个私有对象
  private static HungryMan hm = new HungryMan();

  // 提供一个公共的方法让外界获得该实例
  public static HungryMan getHungryMan() {
    return hm;
  }
}
