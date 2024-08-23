package collection;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'topCompetitors' function below.
	 *
	 * The function is expected to return a STRING_ARRAY.
	 * The function accepts following parameters:
	 *  1. INTEGER topNCompetitors
	 *  2. STRING_ARRAY competitors
	 *  3. STRING_ARRAY reviews
	 */

	public static List<String> topCompetitors(int topNCompetitors, List<String> competitors, List<String> reviews) {
		// Write your code here
		Map<String, Integer> map = new HashMap<>(competitors.size(), 1.0f);
		for (String competitor : competitors) {
			for (String review : reviews) {
				if (review.indexOf(competitor) >= 0) {
					Integer val = map.get(competitor);
					map.put(competitor, val != null ? (val + 1) : 1);
				}

			}
		}
		map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.limit(topNCompetitors)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		List<String> l = new ArrayList<>(topNCompetitors);
		for (String string : map.keySet()) {
			l.add(string);
		}
		return l;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int topNCompetitors = Integer.parseInt(bufferedReader.readLine().trim());

		int competitorsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> competitors = IntStream.range(0, competitorsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		int reviewsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> reviews = IntStream.range(0, reviewsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<String> result = Result.topCompetitors(topNCompetitors, competitors, reviews);

		bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
