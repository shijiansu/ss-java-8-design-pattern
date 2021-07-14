package design.parttern.tarena._7_watcher._3_many2many;

import java.util.List;

public class M2MTest {
  public static void main(String[] args) {
    Sailer s = new Sailer();
    s.setName("Eric");

    Buyer b = new Buyer();
    b.setName("Jason");

    // s.addBuyer( b );
    b.addSailer(s);

    List<Sailer> list = b.getSailerList();
    for (Sailer s2 : list) {
      System.out.println(s2.getName());
    }
  }
}
