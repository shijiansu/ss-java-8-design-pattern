package design.parttern.tarena._4_decorator;

public class DecoratorTest {
  public static void main(String[] args) {
    Weapon gun = new Gun();
    gun.fire();
    System.out.println("=====================================");
    Ak47 ak47 = new Ak47(gun);
    ak47.fire();
    System.out.println("=====================================");
    B43 b43 = new B43(gun);
    b43.fire();
    b43.aimFire();
    System.out.println("=====================================");
    B43 b46 = new B43(ak47); // 装饰类还可以装饰装饰类
    b46.fire();
  }
}
