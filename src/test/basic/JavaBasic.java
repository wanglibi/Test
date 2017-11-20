package test.basic;

import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class JavaBasic {
  
  
  public static void main(String[] args) {
//    ArrayList<E>.class
    List list = new ArrayList();
    err.print(list.size());
    list.add(1);
    err.print(list.size());
//    test4(i,s);
  }
  
  /**
   * 赋值对象
   */
  static void test11(){
    int[] a1 = {1,2,3};
    int [] a2 = a1;
    for(int i = 0;i<a2.length;i++){
      a2[i] = a2[i]+1;
    }
    for(int i = 0;i<a1.length;i++){
      err.println(a1[i]);
    }
  }
  
  /**
   * 静态块与非静态块的区别，静态块只会执行一次
   */
  {
    err.println(2);
    {
      err.println(1);
    }
  }
  static{
      err.println("staitc:"+3);
  }
  
  /**
   * import static java.lang.System.*;
   * 导入类静态属性和方法
   */
  static void test10(){
    out.println("可以直接使用静态属性和方法\n"+in);
  }

  /**
   * 装箱的本质是什么呢？当我们给一个Integer对象赋一个int值的时候，会调用Integer类的静态方法valueOf
   * * public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
   * 简单的说，如果字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象
   
   * @author: wang
   * @time:Mar 18, 2016 3:33:08 PM
   * @title test9
   * @Description: TODO
   */
  static void test9(){
    Integer f3=150,f4 =150;
    System.err.println(f3==f4);
    System.err.println(f3);
    System.err.println(f4);
  }
  
  /**
   * 栈用户存储基本类型和对象的引用
   * 栈的数据是先进后出，就像往枪里面压子弹。
   * 栈的数据可以共享，如：int a = 3,int b = 3,栈里面的数值3是共用的。
   * 堆是先进先出，就像排队。
   */
  static void test8(){
    Stack<String> sk = new Stack<String>();
    sk.push("a");
    sk.push("b");
    sk.push("c");
    System.err.println(sk.search("a")+" "+sk.search("b")+" "+sk.search("c"));
    System.err.println(sk.pop()+" "+sk.pop()+" "+sk.pop());
  }
  
  /**
   * String a = “a”，是在静态池里取出来的，而new String（“a”）是new一个新的对象,s==s1比的是引用地址，所以不同
   *s.hashcode()==s1.hashcode()实际就等同于s.equals(s1);比的是值
   */
  static void test7() {
    String s = "a";
    String s1 = new String("a");
    System.err.println(s == s1);
    System.err.println(s.hashCode() == s1.hashCode());
  }


  /**
   * split方法
   */
  static void test6() {
    String[] ss = ";;a;;;;;;;;;".split(";");// a字符串之前(;;a)截取长度为3，之后因为数值都为空，所以去掉。
    System.err.println(ss.length);
  }


  static String i = "12";
  static String[] s = {"a"};

  /**
   * test4(i,s);
   * 引用值传递不会修改
   * 引用对象传递会被修改
   */
  static void test4(String i, String[] s) {
    i = "34";
    s[0] = "c";
    System.err.println(JavaBasic.i + "   " + JavaBasic.s[0]);
  }

  /**
   * 放入常量池里面
   * 常量放在方法区的
   */
  static void test3() {
    String s = new String("s");
    String s1 = s.intern();// 放入常量池
    System.err.println(s == s1);
  }

  /**
   * 判断回文数字,如：12321
   */
  static boolean test2(int x) {
    if (x < 0) {
      return false;
    }
    int temp = x;
    int y = 0;
    while (temp != 0) {
      y = y * 10 + temp % 10;
      temp = temp / 10;
    }
    return x == y;
  }

  /**
   * 运算符优先级
   */
  static void test1() {
    int x = 10;
    // 优先级:1. ++/-- 2.+/- 3.-=
    x -= ++x - x-- - x;// 20
    x -= ++x + x-- - x;// -2,步骤：（++x + x--） =22;然后x--，x=10;再x-=22-x,x = -2
    System.err.println(x);
  }

  /**
   * getClass是final方法，所以在调用时不会被改变
   * 除非super.getClass().getSuperclass()
   */
  static class test0 extends JavaBasic {
    public void test() {
      System.err.println(super.getClass() == this.getClass());
    }

    public static void main(String[] args) {
      new test0().test();
    }
  }

}
