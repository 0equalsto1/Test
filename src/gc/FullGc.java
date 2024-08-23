package gc;

import java.util.ArrayList;
import java.util.Collection;

public class FullGc {
  private static final Collection<Object> leak = new ArrayList<>();
  public static void main(String[] args) {
	  System.out.println("inside main.....");
    while (true) {
      try {
        leak.add(new byte[1024 * 1024]);
      } catch (OutOfMemoryError e) {
        leak.clear();
        System.out.println("====="+e.getMessage());
        main(args);
      }
    }
  }
}