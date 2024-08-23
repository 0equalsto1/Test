package methodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class MethodReferences {

	public static void main(String[] args) {
		Consumer<String> lambda = s -> System.out.println(s);
		Consumer<String> methodRef = System.out::println;
//		
		DoubleUnaryOperator lm = a -> Math.sqrt(a);
		DoubleUnaryOperator mr = Math::sqrt;

//
		IntBinaryOperator maxLam = (a, b) -> Integer.max(a, b);
		IntBinaryOperator maxRef = Integer::max;
//		
		Function<String, Integer> toLengthLam = s -> s.length();
		Function<String, Integer> toLengthRef = String::length;

//
		BiFunction<String, String, Integer> indexOfLam = (sentence, word) -> sentence.indexOf(word);

		BiFunction<String, String, Integer> indexOfRef = String::indexOf;
//		
		Supplier<List<String>> newListOfStringsLam = () -> new ArrayList<>();

		Supplier<List<String>> newListOfStringsRef = ArrayList::new;

		Function<String, String> id = Function.identity();

		Logger logger = Logger.getLogger("MyApplicationLogger");
		Consumer<String> log = message -> logger.info(message);
		Consumer<String> print = message -> System.out.println(message);

		Consumer<String> printAndLog = log.andThen(print);
		printAndLog.accept("log it....");
	}


}
