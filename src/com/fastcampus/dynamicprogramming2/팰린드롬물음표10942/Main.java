package com.fastcampus.dynamicprogramming2.팰린드롬물음표10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static boolean[][] dp;
    static int[] A;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        dp = new boolean[N + 1][N + 1];
        String[] temp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(temp[i - 1]);

        // dp
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i <= N - 1; i++) {
            if(A[i] == A[i+1]) dp[i][i+1] = true;
        }

        for (int len = 3; len <= N; len++) {
            for (int i = 1; i <= N - (len - 1); i++) {
                int j = i + len - 1;
                if (A[i] == A[j] && dp[i + 1][j - 1]) dp[i][j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            if(dp[start][end]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
