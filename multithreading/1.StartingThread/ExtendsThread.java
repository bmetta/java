class Runner extends Thread {
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class ExtendsThread {
  public static void main(String[] args) {
    Thread th1 = new Runner();
    th1.start();

    Thread th2 = new Runner();
    th2.start();
  }
}
