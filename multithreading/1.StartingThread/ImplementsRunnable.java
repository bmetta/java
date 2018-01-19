class Runner implements Runnable {
  // override
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

public class ImplementsRunnable {
  public static void main(String[] args) {
    Thread thread1 = new Thread(new Runner());
    thread1.start();

    Thread thread2 = new Thread(new Runner());
    thread2.start();
  }
}
