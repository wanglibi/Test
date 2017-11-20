package test.collect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
  static List<Integer> alist = new ArrayList<Integer>(); 
  static List<Integer> klist = new LinkedList<Integer>();
  /**
   * 
   * @Description: 一千万测试
   */
  static void setNum(){
    for(int i=0;i<10000000;i++){
//      alist.add(i);//5.6s  按顺序执行插入，还是arrayList快。
//      klist.add(i);//13.5s
//      alist.add(0, i);//一百万需要137s ，调用arrayCopy方法将index后面位置所有数据往后移动一位。
      klist.add(0, i);//13.9s
    }
  }
  
  public static void main(String[] args) {
    long l = System.currentTimeMillis();
    setNum();
//    alist.add(10, 10);
    System.err.println(System.currentTimeMillis()-l);
  }
}
