package com.baekjoon.solved.삼십;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        StringBuilder sb = new StringBuilder();

        char[] nChar = n.toCharArray();
        Arrays.sort(nChar);
        int temp = 0;
        for (int i = nChar.length - 1; i >= 0; i--) {
            temp += nChar[i] - '0';
            sb.append(nChar[i] - '0');
        }

        if(nChar[0] == '0' && temp % 3 == 0) {
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }

    }
}
