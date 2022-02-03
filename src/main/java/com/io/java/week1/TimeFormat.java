package com.io.java.week1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ResultTime {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String format="";
        SimpleDateFormat inputsdf = new SimpleDateFormat("hh:mm:ssaa");
        SimpleDateFormat outputsdf = new SimpleDateFormat("HH:mm:ss");

        try {
            Date parse = inputsdf.parse(s);
            format = outputsdf.format(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format;
    }

}

public class TimeFormat {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = ResultTime.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
