import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Worker {
  private Random random = new Random();
  
  private Object lock1 = new Object();
  private Object lock2 = new Object();

  private List<Integer> list1 = new ArrayList<Integer>();
  private List<Integer> list2 = new ArrayList<Integer>();

  public void stage1() {
    synchronized (lock1) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      list1.add(random.nextInt(100));
    }
  }

  public void stage2() {
    synchronized (lock2) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      list2.add(random.nextInt(100));
    }
  }
  
  public void process() {
    for (int i = 0; i < 1000; ++i) {
      stage1();
      stage2();
    }
  }

  public void main() {
    long start = System.currentTimeMillis();

    Thread thread1 = new Thread(new Runnable() {
      public void run() {
        process();
      }
    });

    Thread thread2 = new Thread(new Runnable() {
      public void run() {
        process();
      }
    });
    
    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    long end = System.currentTimeMillis();
    System.out.println("Time taken: " + (end - start) + "ms");
    System.out.println("List1 size: " + list1.size());
    System.out.println("List2 size: " + list2.size());
  }
}

public class SynchronizedLocks {
  public static void main(String[] args) {
    Worker worker = new Worker();
    worker.main();
  }
}
