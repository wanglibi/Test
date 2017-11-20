package test.proxy.dyna;

import java.lang.reflect.Proxy;
import java.util.Map;

public class Factory<T> {

  @SuppressWarnings("unchecked")
  public static <T> T newBean(String interfaceClass,Map<String,String> m) throws ClassNotFoundException {
    JdbcProxy<T> jp = new JdbcProxy<>(m);
    Class<?> c = Class.forName(interfaceClass);
    return (T) Proxy.newProxyInstance(c.getClassLoader(), new Class[] {c}, jp);
  }
}
