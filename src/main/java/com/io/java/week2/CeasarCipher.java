package com.io.java.week2;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.stream.Collectors.joining;

class ResultCeasarCipher {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        AtomicReference<String> output = new AtomicReference<>("");
        k=k%26;
        int finalK = k;
        s.chars().forEach(value -> {
            if (65 <= value && value <= 90) { //A-Z
                value = (value + finalK) > 90 ? (value+ finalK - 90) + 64 : value + finalK;
                output.set(output.get().concat(Character.toString((char) value)));
            } else if (97 <= value && value <= 122) { //a-z
                value = (value + finalK) > 122 ? (value+ finalK - 122) + 96 : value + finalK;
                output.set(output.get().concat(Character.toString((char) value)));
            } else { //symbols
                output.set(output.get().concat(Character.toString((char) value)));
            }
        });
        System.out.println(output.get());
        return output.get();
    }

}

public class CeasarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = ResultCeasarCipher.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
