package design.parttern.tarena._7_watcher._3_many2many;

import java.util.List;
import java.util.Vector;

public class Buyer {
  private String name;

  private List<Sailer> sailerList = new Vector<Sailer>();

  public void addSailer(Sailer s) {
    if (false == this.sailerList.contains(s)) {
      this.sailerList.add(s);
    }
    if (false == s.getBuyerList().contains(this)) {
      s.addBuyer(this);
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Sailer> getSailerList() {
    return sailerList;
  }

  public void setSailerList(List<Sailer> sailerList) {
    this.sailerList = sailerList;
  }
}
