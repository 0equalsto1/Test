package streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StreamsInternalWorking {
    static class Internal {
        int id;
        String name;

        public Internal(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Internal{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        Internal in1 = new Internal(1, "one");
        Internal in2 = new Internal(2, "two");
        List<Internal> list = List.of(in1, in2);
        System.out.println("list = " + list);
        AtomicInteger i= new AtomicInteger();
        list.stream()
                .peek(internal -> {
                    System.out.println(internal== list.get(i.getAndIncrement()));
                    internal.setId(internal.getId() * 2);
                })
                .forEach(System.out::println);
        System.out.println("list = " + list);
        /*Stream.of("1", "2", "3", "4")
                .map(Integer::valueOf)
                .filter(i -> i % 2 != 0)
                .forEach(System.out::println); */
     /*   Stream.of("1", "2", "3", "4").map(e -> {
            System.out.println("inside map : " + e);
            return Integer.valueOf(e);
        }).filter(e -> {
            System.out.println("inside filter : " + e);
            return e % 2 != 0;
        }).forEach(e -> {
            System.out.println("inside forEach : " + e);
            System.out.println(e);
        });*/
    }
}
