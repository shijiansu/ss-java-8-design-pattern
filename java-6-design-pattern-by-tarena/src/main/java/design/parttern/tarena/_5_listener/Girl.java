package design.parttern.tarena._5_listener;

import java.util.HashSet;

// 事件源，肯定需调有监听者的引用
public class Girl {
  private HashSet<EmotionListener> lovers = new HashSet<EmotionListener>();
  private String name;

  public Girl(String name) {
    this.name = name;
  }

  // 注册监听者方法
  public void addEmotionListener(EmotionListener lover) {
    lovers.add(lover);
    System.out.println(name + " Say: Someone is with to me!");
  }

  // 注销监听者方法
  public void removeEmotionListener(EmotionListener lover) {
    lovers.remove(lover);
    System.out.println(name + " Say: break up with -> " + lover.toString());
  }

  // 发生情绪
  public void trigger() {
    EmotionEvent event = new EmotionEvent(this);
    for (int i = 1; i <= 10; i++) {
      System.out.println("No " + i + " day: ");
      if (lovers.size() == 0) {
        System.out.println("No one listen to me...");
        continue;
      }
      for (EmotionListener el : lovers) {
        if (i % 2 == 0) {
          // 将事件对象发送给监听者，其实调用监听者的方法，将事件对象作为参数传给这个方法
          el.doWhenSad(event);
        } else {
          el.doWhenHappy(event);
        }
      }
    }
  }

  @Override
  public String toString() {
    return name;
  }

  public String getName() {
    return name;
  }
}
