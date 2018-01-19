import java.util.Scanner;

class Runner extends Thread {
  private volatile boolean running = true;

  public void run() {
    while (running) {
      System.out.println(Thread.currentThread().getName() + " running...");

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName() + " exiting!");
  }

  public void shutdown() {
    running = false;
  }
}

public class ThreadSynchronization {
  public static void main(String[] args) {
    Runner thread = new Runner();
    thread.start();

    // wait for the enter key
    new Scanner(System.in).nextLine();
    thread.shutdown();
  }
}
