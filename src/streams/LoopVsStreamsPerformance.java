package streams;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoopVsStreamsPerformance {
    public static void main(String[] args) {
        Random random = new Random();
        long s = System.currentTimeMillis();
        IntStream randomInts = random.ints(1000000, 1, 9000000); // Generate 10 random integers between 1 and 100
        long count = randomInts.filter(value -> value % 2 == 1).count();
        System.out.println(count + " : " + (System.currentTimeMillis() - s));
        List<Integer> collect = random.ints(1000000, 1, 9000000)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        int c = 0;
        s = System.currentTimeMillis();
        for (Integer integer : collect) {
            if (integer % 2 == 1)
                c++;
        }
        System.out.println(c + " : " + (System.currentTimeMillis() - s));
    }
}
