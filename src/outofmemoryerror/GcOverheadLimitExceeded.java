package outofmemoryerror;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GcOverheadLimitExceeded {
  public static void main(String args[]) throws Exception {
    Map map = System.getProperties();
    Random r = new Random();
    while (true) {
      map.put(r.nextInt(), new HashMap(100));
    }
  }
}