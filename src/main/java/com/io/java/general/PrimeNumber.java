package com.io.java.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = PrimeNumber.primeOrNot(n);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private static String primeOrNot(long n) {
        String result = "";
        int flag = 0;
        if (n == 0 || n == 1) {
            result = "Not Prime";
        } else {
            for (int i = 2; i <= n/2; i++) {
                if (n % i == 0) {
                    result = "Not Prime";
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                result = "Prime";
            }
        }
        System.out.println(result);
        return result;
    }
}