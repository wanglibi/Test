package test.collect;

import java.util.HashSet;
import java.util.Set;
/**
 * HashSet基于HashMap
 */
public class TestSet {
  @Deprecated
  public static void test9(){}
  
  public static void main(String[] args) {
    Set<Object> set=new HashSet<Object>();
    String s = "";
    String s2 = s;
    set.add(s);
    set.add(s2);
    set.add(null);
    set.add(null);
    System.err.println(set.size());
  }
}
