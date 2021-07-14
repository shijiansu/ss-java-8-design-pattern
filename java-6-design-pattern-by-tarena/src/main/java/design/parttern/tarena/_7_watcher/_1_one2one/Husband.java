package design.parttern.tarena._7_watcher._1_one2one;

public class Husband {
  private String name;

  private int age;

  private Wife wife;

  public Husband(Wife w) {
    this.wife = w;
  }

  public Husband() {
    this.wife = new Wife(this);
  }

  public Wife getWife() {
    return wife;
  }

  public void setWife(Wife wife) {
    this.wife = wife;
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
