package design.parttern.tarena._4_decorator;

public class B43 implements Weapon {
  private Weapon w;

  public B43(Weapon w) {
    this.w = w;
  }

  @Override
  public void fire() {
    System.out.println("威力增加10倍");
    w.fire();
  }

  // 还可以提供额外的方法，但依然要依赖于被装饰类来实现
  public void aimFire() {
    System.out.println("瞄准ing");
    w.fire();
  }
}
