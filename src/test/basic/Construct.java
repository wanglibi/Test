package test.basic;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description  初始化之前分配给对象的存储空间为二进制的零。然后按声明顺序进行初始化。
 * 
 * 所以在编写构造器时尽量简单，避免其他方法调用。
 * 
 */
public class Construct{
  public static void main(String[] args) {
//    ArrayList
//    TreeSet
    new B(5);
    A a = new B(1);
    Set s = new TreeSet();
    s.add("14");
    s.add("11");
    s.add("2");
    s.add("3");
    
//    Iterator i = 
//        for(Iterator i：s){
//          
//        }
    for (Iterator iterator = s.iterator(); iterator.hasNext();) {
      Object object = (Object) iterator.next();
      System.err.println(object);
      
    }
//    a.g();
  }
}

class A {
  A() {
    System.err.println("new A before");
    f();
    System.err.println("new A after");
  }
  
  void f() {
    System.err.println("A.f()");
  }
  
  
}

class B extends A {
  private int i = 1;

  B(int i) {
    this.i = i;
    System.err.println("new B，i="+i);
  }

  @Override
  void f() {
    System.err.println("B.f(),i ="+i);//对象B还没创建就被调用，导致默认值都没初始化
  }
  
  void g(){
    
  }
}


