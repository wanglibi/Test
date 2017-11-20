package test.annotation;
/**
 * 自动实现annotation接口
 * @author wang
 * @date  Feb 15, 2017 - 10:35:40 AM
 * @Description
 */
public @interface Anno {
  //通过反射调用方法
  String value();
  String[] value2();
  Class s();
}

class test{
  @Anno(value = "one", value2 = {"1,2,3"}, s = test.class)
  public void tt(){
    
  }
}
