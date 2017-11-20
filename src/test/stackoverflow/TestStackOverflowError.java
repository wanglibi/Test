package test.stackoverflow;

public class TestStackOverflowError {
//  private int stackLength=1;
//  public void stackLeak(){
//      stackLength++;
//      stackLeak();
//  }
//  
//  public static void main(String[]args)throws Throwable {
//      TestStackOverflowError sofe=new TestStackOverflowError();
//      try{
//          sofe.stackLeak();
//      }catch(Throwable e){
//          System.out.println("stack length:" + sofe.stackLength); 
//          throw e;
//      }
//      
//  }
  
  public static void recursion(int totalTimes,int time)  
  {  
      if(totalTimes > 1)  
      {  
          System.out.println("这是第 " +  time + "次调用！");  
          totalTimes--;  
          time++;  
          recursion(totalTimes, time);  
      }  
      else  
      {  
          System.out.println("调用结束，共调用了" + time + "次");  
          return;  
      }  
  }  
    
  public static void main(String[] args)  
  {  
//      int totalTimes = 1000000;  
//      int time = 1;  
//      long startTime = System.currentTimeMillis();  
//      System.out.println("嵌套调用起始时间：" + startTime);  
//      recursion(totalTimes, time);  
//      System.out.println("嵌套调用结束时间：" + System.currentTimeMillis());  
//      System.out.println("总耗时：" + (System.currentTimeMillis() - startTime));  
//      System.out.println("------------------------------------------------------------"); 
    
      double high  = 100;
      double sum = 100;
      for(int i =1;i<=10;i++){
        high = high/2;
        sum += high*2;
        System.err.println("第"+i+"反弹高度："+high);
        System.err.println("第"+i+"反弹总高度："+sum);
      }
  }  
}
