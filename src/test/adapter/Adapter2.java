package test.adapter;

/**
 * 第二种
 */
public class Adapter2 implements Taget {

  private Source source;

  public Adapter2(Source source) {
    super();
    this.source = source;
  }


  @Override
  public void method2() {
    System.err.println("method2");

  }


  @Override
  public void method1() {
    source.method1();

  }

}
