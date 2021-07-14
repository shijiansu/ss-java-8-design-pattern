package design.parttern.tarena._2_singleton;

// 懒汉模式
public class LazyMan {
  private LazyMan() {}

  private static LazyMan lm;

  // 多线程并发的时候会有问题(两个用户第一次同时使用，很少几率发生),需要加锁 synchronized，否则并发操作的时候产生问题
  public static synchronized LazyMan getLazyMan() {
    if (lm == null) {
      lm = new LazyMan();
    }
    return lm;
  }
}
