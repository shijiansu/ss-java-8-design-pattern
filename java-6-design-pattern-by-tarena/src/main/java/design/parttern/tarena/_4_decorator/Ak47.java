package design.parttern.tarena._4_decorator;

/*
 *装饰类, 给其他类提供额外的功能, 不真正干活, 无空参的构造方法, 构造方法一般要传入一个被装饰的对象
 */
public class Ak47 implements Weapon {
  private Weapon w;

  public Ak47(Weapon w) {
    this.w = w;
  }

  @Override
  public void fire() {
    for (int i = 0; i < 10; i++) {
      w.fire(); // 所有功能方法的实现都要依赖于被装饰类
    }
  }
}
