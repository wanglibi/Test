package test.proxy.stat;

public class Test {
  public static void main(String[] args) {
    Dao dao = new JdbcProxy(new DaoImpl());
    dao.findAll();
  }
}
