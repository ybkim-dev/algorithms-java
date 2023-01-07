package com.baekjoon.solved.이항계수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        dp = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        if(K == 0) System.out.println(1);
        else {
            for(int n = 2; n <= N; n++) {
                for (int c = 1; c <= N; c++) {
                    dp[n][c] = (dp[n - 1][c - 1] + dp[n - 1][c]) % 10007;
                }
            }

            System.out.println(dp[N][K]);
        }
    }
}
