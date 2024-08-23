package test;

import java.util.HashMap;
import java.util.Map;

public class GS {
    public static void main(String[] args) {
//        System.out.println(getCharCount("a a"));
        System.out.println(compress("aabbccccaaa".toCharArray()));
    }

    /**
     * aaabbbcccddccff
     * 3a3b3c2d5c2f
     */
    public static String getCharCount(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>(arr.length, 1.0f);
        char prevChar = arr[0];
        for (char curChar : arr) {
            int curVal = map.getOrDefault(curChar, 0);
            map.put(curChar, curVal + 1);
            if (prevChar != curChar)
                sb.append(map.get(prevChar)).append(prevChar);
            prevChar = curChar;
        }
        sb.append(map.get(prevChar)).append(prevChar);
        return sb.toString();
    }

    public static int compress(char[] arr) {

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>(arr.length, 1.0f);
        char prevChar = arr[0];
        for (char curChar : arr) {
            int curVal = map.getOrDefault(curChar, 0);
            map.put(curChar, curVal + 1);
            if (prevChar != curChar) {
                append(sb, map, prevChar);
                map.remove(prevChar);
            }

            prevChar = curChar;
        }
        append(sb, map, prevChar);
        return sb.length();

    }

    private static void append(StringBuilder sb, Map<Character, Integer> map, char prevChar) {
        Integer val = map.get(prevChar);
        if (val > 1)
            sb.append(val).append(prevChar);
        else
            sb.append(prevChar);
    }

}