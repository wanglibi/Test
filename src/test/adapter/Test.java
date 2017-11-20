package test.adapter;


public class Test {
  public static void main(String[] args) {
    //第一种适配方式
    Taget taget = new Adapter();
    taget.method1();
    taget.method2();
    
    //第二种适配方式
    Taget taget2 = new Adapter2(new Source());
    taget2.method1();
    taget2.method2();
  }
}
