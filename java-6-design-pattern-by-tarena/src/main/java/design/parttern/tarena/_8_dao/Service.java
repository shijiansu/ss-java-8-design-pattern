package design.parttern.tarena._8_dao;

// ========程序员B写的Service类========
public class Service {
  private IDAO dao;

  public Service() {
    this.dao = DAOFactory.getDAO();
  }

  public void transfer() {
    dao.sub();
    dao.add();
  }
}
