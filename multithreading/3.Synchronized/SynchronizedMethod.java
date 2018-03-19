/*
 * synchronized keyword provides exclusive locking
 *
 * scenario: two ths increments a shared variable
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
    Thread th1 = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 100000; ++i)
          increment();
      }
    });
    th1.start();

    Thread th2 = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 100000; ++i)
          increment();
      }
    });
    th2.start();

    try {
      th1.join();
      th2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("count : " + count);
  }
}
