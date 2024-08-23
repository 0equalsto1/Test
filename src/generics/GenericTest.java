package generics;

import java.util.List;

public class GenericTest {
    public void upperBoundedExample(List<? extends Number> list) {
        // Read-only access, you can safely read elements
        Number num = list.get(0); // Valid
        Number integer = list.get(1);

        // But you cannot add elements since the actual type is unknown.
        // list.add(new Integer(42)); // Invalid
    }

    public void lowerBoundedExample(List<? super Integer> list) {
        // Write access, you can add elements
        list.add(Integer.valueOf(42)); // Valid
//        list.add(Long.valueOf(100)); //

        // But you cannot safely read elements as Integer since they might be Objects or other superclasses.
        // Integer value = list.get(0); // Invalid
        // Object obj = list.get(1); // Valid, but you'd need to cast to use it as Integer
    }

}
