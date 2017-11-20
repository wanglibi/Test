package test.adapter;

/**
 * 将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
 * 复用了现存的类，解决了现存类和复用环境要求不一致的问题。
 * 将目标类和适配者类解耦，通过引入一个适配器类重用现有的适配者类，而无需修改原有代码。
 * 
 * 适用场景
 * 系统需要使用现有的类，而这些类的接口不符合系统的接口。
 * 旧的系统开发的类已经实现了一些功能，但是客户端却只能以另外接口的形式访问，但我们不希望手动更改原有类的时候。
 * 两个类所做的事情相同或相似，但是具有不同接口的时候。
 */
public class Adapter extends Source implements Taget {

  @Override
  public void method2() {
   System.err.println("method2");
  }
  
}

