package design.parttern.tarena._3_template;

// 模板类
abstract class Drink {
  public void boilWater() {
    System.out.println("water is boiling");
  }

  public void pourInCup() {
    System.out.println("water pour in cup");
  }

  public abstract void addCondiment();

  public abstract void brew();

  public boolean isAdd() {
    return true;
  }

  // 模板方法
  public final void prepareDrink() {
    boilWater();
    brew();
    pourInCup();
    if (isAdd()) {
      addCondiment();
    }
  }

  // 具体实现的子类,方法具有不同 的内容
  static class Coffee extends Drink {
    @Override
    public void addCondiment() {
      System.out.println("add milk");
    }

    @Override
    public void brew() {
      System.out.println("add coffee");
    }
  }

  static class Tea extends Drink {
    @Override
    public void addCondiment() {
      System.out.println("add lemon");
    }

    @Override
    public void brew() {
      System.out.println("add tea");
    }

    // 不一定加lemon
    @Override
    public boolean isAdd() {
      System.out.println("add lemon?");
      return false;
    }
  }
}
