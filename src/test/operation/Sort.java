package test.operation;

import java.util.Date;

/*
 * 排序
 */
public class Sort {

  /**
   * 冒泡排序
   */
  public static void bubbleSort(int[] numbers) {
    int tmp;
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[j] < numbers[i]) {
          tmp = numbers[i];
          numbers[i] = numbers[j];
          numbers[j] = tmp;
        }
      }
    }
  }

  /**
   * 快速排序
   * 
   * 需要修改堆栈大小。打开preferences－Java －Installed JREs －Edit  
   * 在Default VM Arguments输入：-Xmx128m -Xms64m -Xmn32m -Xss16m  //Xss是堆栈的大小。
   * 
   */
  public static void quickSort(int n[], int start, int end) {
    if (start < end) {//防止无限递归
      int s = start;
      int e = end;
      int tmp = n[start];
      while (s < e) {//多次计算：把小于tmp放左边，大于tmp放右边
        
        while (s < e & n[e] >= tmp) {//过滤右边大于tmp的数字
          e--;
        }
        n[s] = n[e];//将小于tmp的数字放置在i位置上
        
        while (s < e & n[s] < tmp) {//过滤左边小于tmp的数字
          s++;
        }
        n[e] = n[s];//将大于tmp的数字放置在j位置上
      }
      n[s] = tmp;
      quickSort(n, start, s - 1);//递归左边数据
      quickSort(n, s + 1, end);//递归右边数据
    }
  }

  public static void main(String[] args) {

    int [] num = new int[1000000];
    for(int i =0;i<1000000;i++){
      if(i<50000){
        num[i]=i+49999;
      }else{
        num[i]=i-49999;
      }
    }
    Date d  =new Date();
//    bubbleSort(num); // 十万排序 4秒 百万排序400秒
    
    quickSort(num, 0, num.length - 1); //十万排序 4秒
    Date d1  =new Date();
    System.err.println(d1.getTime()-d.getTime());
  }
}
