package test.proxy.dyna;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class JdbcProxy<T> implements InvocationHandler {

  private Map<String,String> methodMap;
  
  public JdbcProxy(Map<String,String> methodMap){
    this.methodMap = methodMap;
  }
  
  public void setMethodMap(Map<String, String> methodMap) {
    this.methodMap = methodMap;
  }
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (Object.class.equals(method.getDeclaringClass())) {
      return method.invoke(this, args);
    }
    
    System.err.println("连接jdbc");
    System.err.println(methodMap.get(method.getName()));
    System.err.println("关闭jdbc");
    return "";
    
  }
  
}
