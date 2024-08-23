package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ConstructorMethodReference {
	static List<List<? extends Number>> history = new ArrayList<List<? extends Number>>();


	public static void main(String args[]) {
		IntStream.range(0, 20).forEach(System.out::println);
		
		final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// Method Reference
//		copyElements(list, ArrayList<Integer>::new);
		// Lambda expression
//		copyElements(list, () -> new ArrayList<>());
	}

	private static void copyElements(final List<Integer> list, final Supplier<Collection<Integer>> targetCollection) {
		// Method reference to a particular instance
		list.forEach(System.out::println);
		list.forEach(targetCollection.get()::add);
		System.out.println(targetCollection.get());
	}
}