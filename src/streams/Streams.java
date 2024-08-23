package streams;

import java.util.List;
import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IntStream range = IntStream.range(1, 10);
        range.filter(e -> {
                    System.out.println("filter");
                    return e > 0;
                })
                .mapToObj(e -> {
                    System.out.println("map");
                    return Integer.toBinaryString(e);
                })
                .toList()
                .forEach(s -> {
                    System.out.println("forEach : " + s);
                });

    }

}
