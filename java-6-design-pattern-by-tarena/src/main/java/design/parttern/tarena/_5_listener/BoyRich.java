package design.parttern.tarena._5_listener;

// 监听者
public class BoyRich implements EmotionListener {
  private String name;

  public BoyRich(String name) {
    this.name = name;
  }

  public void doWhenHappy(EmotionEvent event) {
    Girl g = (Girl) event.getSource();
    String girlName = g.getName();
    System.out.println(girlName + " -> " + name + ": I feel happy today@ X @");
    System.out.println(name + " -> " + girlName + ": I buy you a car!!");
  }

  public void doWhenSad(EmotionEvent event) {
    Girl g = (Girl) event.getSource();
    String girlName = g.getName();
    System.out.println(girlName + " -> " + name + ": I feel upset today 888888");
    System.out.println(name + " -> " + girlName + ": I buy you a house...");
  }

  @Override
  public String toString() {
    return "Boy [name=" + name + "]";
  }
}
