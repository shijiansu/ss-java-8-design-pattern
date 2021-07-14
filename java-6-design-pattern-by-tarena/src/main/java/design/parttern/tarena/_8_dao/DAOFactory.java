package design.parttern.tarena._8_dao;

// ========系统设计师写的DAO工厂========
// DAO工厂,模拟其运行机制
public class DAOFactory {
  public static IDAO getDAO() {
    return new DAOImpl();
  }
}
