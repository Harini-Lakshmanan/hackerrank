package com.io.java.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result{

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        AtomicReference<Double> countPositive = new AtomicReference<>(0.0);
        AtomicReference<Double> countNegative = new AtomicReference<>(0.0);
        AtomicReference<Double> count = new AtomicReference<>(0.0);

        List<Object> collect = arr.stream()
                .map(integer -> {
            if (integer > 0) countPositive.getAndSet(countPositive.get() + 1);
            else if (integer < 0) countNegative.getAndSet(countNegative.get() + 1);
            else count.getAndSet(count.get() + 1);
            return null;
        }).collect(toList());

        System.out.println(collect);
        System.out.println("Greater than 0 :"+ BigDecimal.valueOf(countPositive.get()).divide(BigDecimal.valueOf(arr.size()),6,5));
        System.out.println("Less than 0 :"+ BigDecimal.valueOf(countNegative.get()).divide(BigDecimal.valueOf(arr.size()),6,5));
        System.out.println("Equals 0 :"+ BigDecimal.valueOf(count.get()).divide(BigDecimal.valueOf(arr.size()),6,5));
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
