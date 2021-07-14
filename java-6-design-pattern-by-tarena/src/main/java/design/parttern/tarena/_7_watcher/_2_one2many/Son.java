package design.parttern.tarena._7_watcher._2_one2many;

public class Son {
  private String name;

  private Father father;

  public Son(Father f) {
    this.father = f;
    this.father.addSon(this);
  }

  public Father getFather() {
    return father;
  }

  public void setFather(Father father) {
    this.father = father;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
