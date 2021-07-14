package design.parttern.tarena._5_listener;

import java.util.EventListener;

// 监听接口，目的是解耦合，由事件触发，无返回值，特点是传进去一个参数
interface EmotionListener extends EventListener {
  void doWhenHappy(EmotionEvent event);

  void doWhenSad(EmotionEvent event);
}
