package com.io.java.week2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultCounterGame {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static String counterGame(long n) {
        // Write your code here
        String player1 = "Louise";
        String player2 = "Richard";

        String binary = Long.toBinaryString(n);

        // The number of 1's (until the last) represent the number
        // of turns / subtractions until the result is a power of 2
        long turns = binary.chars().filter(ch -> ch == '1').count() - 1;

        // Add to turns the number of zeros ofter the last 1
        // which will be the turns / div by 2 until 1 is reached
        turns += binary.length() - (binary.lastIndexOf("1") + 1);

        // If the number of turns is even, player 2 will win
        return turns % 2 == 0? player2 : player1;
    }

}

public class CounterGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = ResultCounterGame.counterGame(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
