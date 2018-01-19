/*
 * synchronized keyword provides exclusive locking
 */
public class SynchronizedMethod {
  public static void main(String[] args) {
    SynchronizedMethod worker = new SynchronizedMethod();
    worker.run();
  }
  
  private int count = 0;

  //public void increment() {
  //  count++;
  //}

  public synchronized void increment() {
    count++;
  }

  public void run() {
    Thread thread1 = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 100000; ++i)
          increment();
      }
    });
    thread1.start();

    Thread thread2 = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 100000; ++i)
          increment();
      }
    });
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("count : " + count);
  }
}
