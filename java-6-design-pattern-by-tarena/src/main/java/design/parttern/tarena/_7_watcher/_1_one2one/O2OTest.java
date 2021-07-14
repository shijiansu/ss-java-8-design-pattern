package design.parttern.tarena._7_watcher._1_one2one;

public class O2OTest {

  public static void main(String[] args) {
    Husband h = new Husband();
    h.setName("Jason");
    Wife w = h.getWife();
    w.setName("Coco");

    System.out.println("husband: " + w.getHusband().getName());
    System.out.println("wife: " + h.getWife().getName());
  }
}
