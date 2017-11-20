package test.thread.daemon;

import java.util.Scanner;

/**
 * 守护进程
 * Java语言自己可以创建两种进程“用户线程”和“守护线程”
 * 用户线程：就是我们平时创建的普通线程.
 * 守护线程：主要是用来服务用户线程.
 * 那么如何来区分这两种线程呢？
 * 
 * 当线程只剩下守护线程的时候，JVM就会退出.但是如果还有其他的任意一个用户线程还在，JVM就不会退出.
 */
public class DaemonRunner implements Runnable {

  public void run() {
    while (true) {
      for (int i = 1; i <= 100; i++) {

        System.out.println(i);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    Thread daemonThread = new Thread(new DaemonRunner());
    // 设置为守护进程
    daemonThread.setDaemon(true);
    daemonThread.start();
    Scanner scanner = new Scanner(System.in);
    // 接受输入，使程序在此停顿，一旦接受到用户输入,main线程结束，JVM退出!
    scanner.next();
    System.err.println(123);
    // AddShutdownHook方法增加JVM停止时要做处理事件：
    // 当JVM退出时，打印JVM Exit语句.
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // TODO Auto-generated method stub
        System.out.println("JVM Exit!");
      }
    });
  }
}
