package com.io.java.week2;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class ResultSalesByMatch {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        AtomicInteger count = new AtomicInteger();
        ar.stream()
                .filter(integer -> Collections.frequency(ar, integer) >= 2)
                .forEach(integer -> {
                    if (!map.containsKey(integer)) {
                        map.put(integer, Collections.frequency(ar, integer));
                    }
                });

        map.entrySet().stream()
                .forEach(integerIntegerEntry -> {
                    count.getAndAdd(integerIntegerEntry.getValue() / 2);
                });
        System.out.println(map);
        System.out.println(count.intValue());
        return count.intValue();
    }

}

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultSalesByMatch.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
