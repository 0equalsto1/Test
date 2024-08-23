package streams;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@SuppressWarnings("ALL")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ListToMap {
    static List<Item> items = null;

    @BeforeAll
    static void setUp() {
        items = Arrays.asList(new Item("apple", 10, new Double("9.99")),
                new Item("banana", 20, new Double("19.99")), new Item("orang", 10, new Double("29.99")),
                new Item("watermelon", 10, new Double("29.99")), new Item("papaya", 15, new Double("9.99")),
                new Item("papaya", 20, new Double("9.99")), new Item("apple", 10, new Double("9.99")),
                new Item("banana", 10, new Double("19.99")), new Item("apple", 20, new Double("9.99")));
    }

    @Test
    public void listToMapUsingStreamsApi() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 2, 2, 3, 4, 5, 6, 1, 6, 7, 8, 9);

        Map<Integer, Integer> occurrenceMap = integerList
                .stream().
                collect(Collectors.toMap(num -> num,                // Key mapper: use the number itself as the key
                        num -> 1,                   // Value mapper: set initial value to 1
                        Integer::sum               // Merge function: sum the values in case of duplicates
                ));

        Map<Integer, Long> occurrenceMap2 = integerList.stream()
                .collect(Collectors.groupingBy(
                        num -> num,                // Key mapper: use the number itself as the key
                        Collectors.counting()      // Value mapper: count the occurrences of each number
                ));
        System.out.println(occurrenceMap);
        System.out.println(occurrenceMap2);
    }

    @Test
    public void listToMapValueAsSetAndList() {
        Map<Double, List<Item>> resultList2 = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice));
        Map<Double, Set<Item>> resultSet2 = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, Collectors.toSet()));

        System.out.println(resultSet2);
        Map<Double, Set<String>> resultSet = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));
        Map<Double, List<String>> resultList = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toList())));

        System.out.println(resultSet);

        /*Map<String, Map<Integer, List<String>>> gropByTwoParam = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.groupingBy(Item::getQty,
                        Collectors.mapping(Item::getName, Collectors.toList()))));
        System.out.println(gropByTwoParam);*/
    }

    public static void main(String[] args) {
        setUp();

        // 3 apple, 2 banana, others 1
        // group by price
        Map<Double, List<Item>> groupByPriceMap = items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

        Map<String, Integer> sum = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println(sum);

        Map<String, Map<Integer, List<Item>>> gropByTwoParam = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.groupingBy(Item::getQty)));
        System.out.println(gropByTwoParam);

        Map<String, Double> gropByAvg = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.averagingDouble(Item::getQty)));
        System.out.println(gropByAvg);
    }

}

class Item {

    private String name;
    private int qty;
    private Double price;
    private Object obj;

    public Item(String name, int qty, Double price) {
        super();
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        this.obj = obj;
        if (this == obj)
            return true;
        Item it = (Item) obj;
        return this.getName().equals(it.getName());
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", qty=" + qty + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
