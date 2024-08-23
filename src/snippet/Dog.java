package snippet;

import java.util.HashMap;
import java.util.Map;

public class Dog extends Animal {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = {10, 20, 20, 10, 10, 20, 5, 20,5};
        int count = 0;
        for (int key : arr) {
            int value = map.getOrDefault(key, 0) + 1;
            map.put(key, value);
            if (value == 2)
                count++;
        }
        System.out.println(count);
    }
}
