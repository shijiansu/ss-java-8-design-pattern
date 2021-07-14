package design.parttern.tarena._8_dao;

// ========程序员A写的DAO类========
public class DAOImpl implements IDAO {
  @Override
  public void add() {
    System.out.println("钱存入了一个帐户");
  }

  @Override
  public void sub() {
    System.out.println("钱从一个帐户中取出");
  }

  @Override
  public void modi() {}

  @Override
  public Object get() {
    return null;
  }
}
