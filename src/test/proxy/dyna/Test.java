package test.proxy.dyna;

import java.util.HashMap;
import java.util.Map;

public class Test {
  
  public static void main(String[] args) throws ClassNotFoundException {
    String daoClass = "test.proxy.dyna.Dao";
    Map<String,String> m = new HashMap<>();
    m.put("findAll", "select * from user");
    
    
    Dao dao =  Factory.newBean(daoClass,m);
    dao.findAll();
  }
}
