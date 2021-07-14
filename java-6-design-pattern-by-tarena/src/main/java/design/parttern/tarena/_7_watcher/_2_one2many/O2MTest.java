package design.parttern.tarena._7_watcher._2_one2many;

import java.util.List;

public class O2MTest {

  public static void main(String[] args) {
    Father f = new Father();
    f.setName("Jason");

    Son s1 = new Son(f);
    s1.setName("Google");
    Son s2 = new Son(f);
    s2.setName("BaiDu");

    System.out.println("s1: " + s1.getFather().getName());
    System.out.println("s2: " + s2.getFather().getName());
    System.out.println("-----------------------------");

    List<Son> list = f.getSonList();
    for (Son son : list) {
      System.out.println(son.getName());
    }
  }
}
