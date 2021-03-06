public class AnonymousThread {
  public static void main(String[] args) {
    Thread th = new Thread(new Runnable() {
      // override
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println(Thread.currentThread().getName() + " " + i);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    th.start();

    new Thread(new Runnable() {
      // override
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println(Thread.currentThread().getName() + " " + i);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();
  }
}
