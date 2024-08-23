package leetcode.intrv;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(isAnagram("silsent", "llisten"));
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        Map<Character, Integer> map = new HashMap<>(s1.length(), 1.0f);

        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c))
                return false;
            map.put(c, map.get(c) - 1);
        }
        long sum = map.values().stream().filter(e -> e > 0).count();
        return sum == 0;
    }
    //emp(name,email)(a,a.gmail)
    //select name ,email,count(*) as c form emp group by name,email having  c > 1 ;

}

