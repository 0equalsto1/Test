package referenceTypes;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakVsNormal {

  public static void main(String[] args) {
      List<Reference<MyObject>> references = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
          MyObject myObject = new MyObject("weak " + i);
          Reference<MyObject> ref = new WeakReference(myObject);
          references.add(ref);
          new MyObject("normal " + i);
      }
      SoftVsNormal.printReferences(references);
  }
}