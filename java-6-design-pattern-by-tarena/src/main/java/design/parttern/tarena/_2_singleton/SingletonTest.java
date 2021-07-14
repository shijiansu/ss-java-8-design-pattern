package design.parttern.tarena._2_singleton;

public class SingletonTest {
  public static void main(String[] args) {
    System.out.println(HungryMan.getHungryMan());
    System.out.println(HungryMan.getHungryMan()); // 一样
    System.out.println(LazyMan.getLazyMan());
    System.out.println(LazyMan.getLazyMan()); // 一样
  }
}
