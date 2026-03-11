package language.collections;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Teeing {
	public void teeingStrings(){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		var result = numbers.stream()
			.collect(Collectors.teeing( // that combines the results of two collectors into a single collector
				Collectors.filtering(n -> n % 2 == 0, Collectors.toList()), // Each collector independently processes the elements
				Collectors.filtering(n -> n % 2 != 0, Collectors.toList()),
				(evens, odds) -> String.format("Evens: %s, Odds: %s", evens, odds) // merger function
			)); // hint: ctrl-click the "teeing" to see under the hood
/*
That is:
	public static <T, R1, R2, R>
	Collector<T, ?, R> teeing
	(	Collector<? super T, ?, R1> downstream1
	,	Collector<? super T, ?, R2> downstream2
	,	BiFunction<? super R1, ? super R2, R> merger
	) {
		return teeing0(downstream1, downstream2, merger);
	}
*/
		System.out.println(result);
	}

	public void teeingIntegers() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Calculate average and sum simultaneously
		var result = numbers.stream()
			.collect(Collectors.teeing(
				Collectors.summingInt(i -> i),
				Collectors.counting(),
				(sum, count) -> new AbstractMap.SimpleEntry<>(sum, sum / (double) count)
			));

		System.out.println("Sum: " + result.getKey());
		System.out.println("Average: " + result.getValue());
	}
}
