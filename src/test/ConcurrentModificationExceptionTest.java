package test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ConcurrentModificationExceptionTest  {
    public static void main(String[] args) throws ConcurrentModificationException {
        Object o = new Object();
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
       /* for (int i = 0; i < integers.size(); i++) {
            Integer integer =  integers.get(i);
            if(i>2){
                integers.remove(i-1);
            }
        }*/
        int i=0;
        for (Integer integer : integers) {
            integers.remove(i);
        }

        System.out.println(integers);
    }
}
