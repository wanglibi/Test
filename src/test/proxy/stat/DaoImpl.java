package test.proxy.stat;

public class DaoImpl implements Dao {

  @Override
  public void findAll() {
    System.err.println("select * from test;");

  }

}
