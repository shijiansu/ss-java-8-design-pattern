package design.parttern.tarena._7_watcher._2_one2many;

import java.util.List;
import java.util.Vector;

public class Father {
  private String name;

  private List<Son> sonList = new Vector<Son>();

  public void addSon(Son son) {
    this.sonList.add(son);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Son> getSonList() {
    return sonList;
  }

  public void setSonList(List<Son> sonList) {
    this.sonList = sonList;
  }
}
