package design.parttern.tarena._4_decorator;

/*
 *功能类，功能单一，真正干活
 */
public class Gun implements Weapon {
  @Override
  public void fire() {
    System.out.println("发射一发子弹");
  }
}
