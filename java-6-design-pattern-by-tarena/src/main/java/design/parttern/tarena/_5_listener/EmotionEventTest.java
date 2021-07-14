package design.parttern.tarena._5_listener;

public class EmotionEventTest {
  public static void main(String[] args) {
    // 事件源
    Girl g = new Girl("hotGirl");
    // 监听者
    EmotionListener b = new Boy("jsutABoy");
    EmotionListener b2 = new BoyRich("richBoy");
    //
    g.addEmotionListener(b);
    g.addEmotionListener(b2);
    g.trigger();
    //
    System.out.println();
    //
    g.removeEmotionListener(b);
    g.trigger();
    //
    System.out.println();
    //
    g.removeEmotionListener(b2);
    g.trigger();
  }
}
// hotGirl Say: Someone is with to me!
// hotGirl Say: Someone is with to me!
// No 1 day:
// hotGirl -> jsutABoy: I feel happy today@ X @
// jsutABoy -> hotGirl: Me too!!
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 2 day:
// hotGirl -> jsutABoy: I feel upset today 888888
// jsutABoy -> hotGirl: Me either...
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
// No 3 day:
// hotGirl -> jsutABoy: I feel happy today@ X @
// jsutABoy -> hotGirl: Me too!!
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 4 day:
// hotGirl -> jsutABoy: I feel upset today 888888
// jsutABoy -> hotGirl: Me either...
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
// No 5 day:
// hotGirl -> jsutABoy: I feel happy today@ X @
// jsutABoy -> hotGirl: Me too!!
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 6 day:
// hotGirl -> jsutABoy: I feel upset today 888888
// jsutABoy -> hotGirl: Me either...
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
// No 7 day:
// hotGirl -> jsutABoy: I feel happy today@ X @
// jsutABoy -> hotGirl: Me too!!
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 8 day:
// hotGirl -> jsutABoy: I feel upset today 888888
// jsutABoy -> hotGirl: Me either...
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
// No 9 day:
// hotGirl -> jsutABoy: I feel happy today@ X @
// jsutABoy -> hotGirl: Me too!!
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 10 day:
// hotGirl -> jsutABoy: I feel upset today 888888
// jsutABoy -> hotGirl: Me either...
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
//
// hotGirl Say: break up with -> Boy [name=jsutABoy]
// No 1 day:
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 2 day:
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
// No 3 day:
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 4 day:
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
// No 5 day:
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 6 day:
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
// No 7 day:
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 8 day:
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
// No 9 day:
// hotGirl -> richBoy: I feel happy today@ X @
// richBoy -> hotGirl: I buy you a car!!
// No 10 day:
// hotGirl -> richBoy: I feel upset today 888888
// richBoy -> hotGirl: I buy you a house...
//
// hotGirl Say: break up with -> Boy [name=richBoy]
// No 1 day:
// No one listen to me...
// No 2 day:
// No one listen to me...
// No 3 day:
// No one listen to me...
// No 4 day:
// No one listen to me...
// No 5 day:
// No one listen to me...
// No 6 day:
// No one listen to me...
// No 7 day:
// No one listen to me...
// No 8 day:
// No one listen to me...
// No 9 day:
// No one listen to me...
// No 10 day:
// No one listen to me...
