package com.fastcampus.dynamicprogramming2.계단오르기2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    static int[][] dp;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1][2];
        dp[1][0] = 0;
        dp[1][1] = A[1];


        if(N >= 2) {
            dp[2][0] = A[2];
            dp[2][1] = A[1] + A[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + A[i];
            dp[i][1] = dp[i - 1][0] + A[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));

    }
}
