package test.basic;

import java.util.Timer;

public class Book extends Exception{
  public Book(){
    System.err.println("Book");
  }
  protected void finalize(){
      System.err.println("Error:checked Out");
  }
  
  
  protected void dispose() {
    System.err.println(123);
  }
  
  public static void main(String[] args) {
    new Book();
    System.gc();
  }
  
}
