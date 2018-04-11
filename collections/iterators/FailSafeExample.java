import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;

public class FailSafeExample {
  public static void main(String[] args) {
    ConcurrentHashMap<String, String> phones =
        new ConcurrentHashMap<String, String>();

    phones.put("Apple", "iPhone");
    phones.put("HTC", "HTC One");
    phones.put("Samsung", "S5");
    
    Iterator it = phones.keySet().iterator();
    while(it.hasNext()) {
      System.out.println(phones.get(it.next()));
      phones.put("Sony", "Xperia Z");
    }
  }
}
