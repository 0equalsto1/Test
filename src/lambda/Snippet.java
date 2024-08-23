package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Snippet {
	@SuppressWarnings("rawtypes")
	public static Map<String, Long> groupByKey(List<Map> list, String key) {
		return list.stream().
				collect(Collectors.groupingBy(e -> e.get(key).toString(), Collectors.counting()));
	}
	@SuppressWarnings("rawtypes")
	public static Map<Object, List<Map>> groupByKey2(List<Map> list, String key) {
		return list.stream().
				collect(Collectors.groupingBy(e -> e.get(key).toString()));
	}
public static void main(String[] args) {
        
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);


    }
}
