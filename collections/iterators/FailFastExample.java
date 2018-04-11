import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastExample {
  public static void main(String[] args) {
    Map<String, String> phones = new HashMap<String, String>();

    phones.put("Apple", "iPhone");
    phones.put("HTC", "HTC One");
    phones.put("Samsung", "S5");
    
    Iterator it = phones.keySet().iterator();
    while(it.hasNext()) {
      System.out.println(phones.get(it.next()));
      phones.put("Sony", "Xperia Z"); // throws ConcurrentModificationException exception
    }
  }
}
