package test.iterator;

public class Test {
  public static void main(String[] args) {
    List l = new List();
    for(int i =0;i<256;i++){
      l.add(i);
    }
    Iterator i = l.iterator();
    while(i.hasNext()){
      System.err.println(i.next());
    }
    
    l.removeAll();
    System.err.println(l.size());
  }
}
