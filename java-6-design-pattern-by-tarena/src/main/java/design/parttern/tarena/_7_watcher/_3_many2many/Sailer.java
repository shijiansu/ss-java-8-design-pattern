package design.parttern.tarena._7_watcher._3_many2many;

import java.util.List;
import java.util.Vector;

public class Sailer {
  private String name;

  private List<Buyer> buyerList = new Vector<>();

  public void addBuyer(Buyer b) {
    if (!this.buyerList.contains(b)) {
      this.buyerList.add(b);
    }
    if (!b.getSailerList().contains(this)) {
      b.addSailer(this);
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Buyer> getBuyerList() {
    return buyerList;
  }

  public void setBuyerList(List<Buyer> buyerList) {
    this.buyerList = buyerList;
  }
}
