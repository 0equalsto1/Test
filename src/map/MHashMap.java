package map;

import java.util.HashMap;

public class MHashMap {
    public static void main(String[] args) {
        System.out.println("hashMap");
        HashMap<Integer, String> hashMap = new HashMap<>(1, 1.0f);
        hashMap.put(1, "1");
        System.out.println(hashMap);
        /*hashMap.put(2, "2");
        hashMap.put(3, "3");
        hashMap.put(4, "4");
        hashMap.put(5, "5");
        hashMap.put(6, "6");
        hashMap.put(7, "7");
        hashMap.put(8, "8");
        hashMap.put(9, "9");
        hashMap.put(10, "10");
        System.out.println(hashMap);
        System.out.println(Math.ceil(16 / (double)0.75));*/
    }

}