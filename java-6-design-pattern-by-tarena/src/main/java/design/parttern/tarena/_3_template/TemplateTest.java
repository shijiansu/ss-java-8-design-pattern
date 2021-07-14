package design.parttern.tarena._3_template;

import design.parttern.tarena._3_template.Drink.Coffee;
import design.parttern.tarena._3_template.Drink.Tea;

public class TemplateTest {
  public static void main(String[] args) {
    Coffee c = new Coffee();
    c.prepareDrink();
    Tea t = new Tea();
    t.prepareDrink();
  }
}
