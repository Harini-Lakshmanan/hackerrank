package com.io.java.week1;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultMin {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        BigInteger sum= BigInteger.ZERO;
        BigInteger maxSum= BigInteger.ZERO;
        BigInteger tempSum= BigInteger.ZERO;
        Collections.sort(arr);
        for(int i=0;i< arr.size();i++){
            sum = BigInteger.valueOf(arr.get(i)).add(tempSum);
            tempSum = sum;
        }

        maxSum = sum.subtract(BigInteger.valueOf(arr.get(0)));
        BigInteger minSum = sum.subtract(BigInteger.valueOf(arr.get(arr.size()-1)));
        System.out.println(minSum+" "+maxSum);

        //JAVA 8
        Integer integer1 = arr.stream()
                .reduce((integer, integer2) -> integer + integer2).get();
        System.out.println(integer1);
        int size = arr.size();
        System.out.println(integer1-arr.get(size-1)+" "+(integer1-arr.get(0)));
    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultMin.miniMaxSum(arr);

        bufferedReader.close();
    }
}
