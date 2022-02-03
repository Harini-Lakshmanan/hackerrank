package com.io.java.week1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultLonelyInteger {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        //Find unique element in a list
        Integer number = a.stream()
                .filter(integer -> Collections.frequency(a, integer) == 1)
                .findFirst().get();

        //Find duplicate elements in list
        List<Integer> duplicateList = a.stream().filter(integer -> Collections.frequency(a, integer) > 1)
                .distinct()
                .collect(toList());
        System.out.println("Duplicate Elements in list -->"+duplicateList);

        List<Integer> uniqueList = a.stream().distinct().collect(toList());
        System.out.println("Unique elements in list -->"+uniqueList);


        return number;
    }

}

public class LonelyInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultLonelyInteger.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
