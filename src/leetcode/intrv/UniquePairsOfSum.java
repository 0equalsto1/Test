package leetcode.intrv;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;



class Result {

    public static int stockPairs(List<Integer> stocksProfit, long target) {

    Set<Integer> s1 = new HashSet<>();
    Set<Integer> s2 = new HashSet<>();
    int count=0;
    for (Integer sp : stocksProfit) {
        if(s1.contains((int)(target-sp)) && !s2.contains(sp)){
            count++;
            s2.add((int)(target-sp));
            s2.add(sp);
        }
        else if(!s1.contains(sp)){
            s1.add(sp);
        }
    }
    return count;
    }

}

public class UniquePairsOfSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stocksProfitCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> stocksProfit = IntStream.range(0, stocksProfitCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long target = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.stockPairs(stocksProfit, target);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
