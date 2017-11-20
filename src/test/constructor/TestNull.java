package test.constructor;

/**
 * null本身虽然能代表一个不确定的对象，但就null本身来说，它不是对象，也不知道什么类型.
 */
public class TestNull {
  
  public TestNull(String s){
    System.err.println("s");
  }
  
  public TestNull(Object o){
    System.err.println("o");
  }
  
  public static void main(String[] args) {
    new TestNull(null);
  }
}
