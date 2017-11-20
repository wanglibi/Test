package test.proxy.stat;

public class JdbcProxy implements Dao{

  private Dao dao;
  
  
  public JdbcProxy(Dao dao) {
    super();
    this.dao = dao;
  }

  public void findAll() {
    System.err.println("创建连接");
    dao.findAll();
    System.err.println("断开连接");
    
  }
}
