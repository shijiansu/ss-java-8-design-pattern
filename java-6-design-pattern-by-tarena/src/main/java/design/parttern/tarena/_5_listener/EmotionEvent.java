package design.parttern.tarena._5_listener;

import java.util.EventObject;

// 事件对象
public class EmotionEvent extends EventObject {
  private static final long serialVersionUID = -2507409384025320544L;

  public EmotionEvent(Object source) {
    // 父类没有空参的构造方法
    super(source);
  }
}
