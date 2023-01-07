package com.baekjoon.solved.다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] temp = br.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);

            dp = new int[M+1][M+1];

            for(int i = 0; i <= M; i++) {
                dp[i][0] = 1;
                dp[i][i] = 1;
            }
            for(int i = 2; i <= M; i++) {
                for(int j = 1; j <= N; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }

            System.out.println(dp[M][N]);
        }
    }
}
