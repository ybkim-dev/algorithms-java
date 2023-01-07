package com.fastcampus.dynamicprogramming2.RGB거리1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] A;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N + 1][3];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split(" ");
            A[i][0] = Integer.parseInt(temp[0]);
            A[i][1] = Integer.parseInt(temp[1]);
            A[i][2] = Integer.parseInt(temp[2]);
        }

        dp[1][0] = A[1][0];
        dp[1][1] = A[1][1];
        dp[1][2] = A[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + A[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + A[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + A[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}
