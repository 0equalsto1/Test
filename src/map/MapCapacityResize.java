package map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MapCapacityResize {
    public static void main(String[] args) {
        Map<Integer, Integer> a = new HashMap<>();
        fill12(a);
        System.out.println("a = " + a);
        Map<Integer, Integer> b = new HashMap<>(12);
        fill12(b);
        System.out.println("b = " + b);
        Map<Integer, Integer> c = new HashMap<>(a);
        System.out.println("c = " + c);
        Map<Integer, Integer> d = new HashMap<>();
        d.putAll(a);
        System.out.println("d = " + d);

    }

    private static void fill12(Map<Integer, Integer> a) {
        IntStream.range(1, 13).forEach(key -> a.put(key, key));
    }
}
