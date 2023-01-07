package com.baekjoon.solved.잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sent = br.readLine();

        int sum = Integer.MAX_VALUE;

        String[] splitByMinus = sent.split("-");

        for (int i = 0; i < splitByMinus.length; i++) {
            int temp = 0;
            String[] splitByPlus = splitByMinus[i].split("\\+");

            for (int j = 0; j < splitByPlus.length; j++) {
                temp += Integer.parseInt(splitByPlus[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
