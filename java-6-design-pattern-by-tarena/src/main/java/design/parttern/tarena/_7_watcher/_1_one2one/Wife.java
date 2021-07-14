package design.parttern.tarena._7_watcher._1_one2one;

public class Wife {
  private String name;

  private int age;

  private Husband husband;

  public Wife(Husband h) {
    this.husband = h;
  }

  public Wife() {
    this.husband = new Husband(this);
    // this.husband.setWife(this);
  }

  public Husband getHusband() {
    return husband;
  }

  public void setHusband(Husband husband) {
    this.husband = husband;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
