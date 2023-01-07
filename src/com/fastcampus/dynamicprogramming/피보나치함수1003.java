package com.fastcampus.dynamicprogramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수1003 {
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            DP = new int[41][2];
            DP[0][0] = 1; DP[0][1] = 0; DP[1][0] = 0; DP[1][1] = 1;

            for(int i = 2; i <= n; i++) {
                DP[i][0] = DP[i-1][0] + DP[i-2][0];
                DP[i][1] = DP[i-1][1] + DP[i-2][1];
            }
            StringBuilder sb = new StringBuilder();
            sb.append(DP[n][0]).append(" ").append(DP[n][1]);
            System.out.println(sb.toString());
        }
    }
}
