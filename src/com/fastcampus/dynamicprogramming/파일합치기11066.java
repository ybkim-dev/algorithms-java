package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파일합치기11066 {
    static int[][] DP;
    static int T;
    static int N;
    static int[] cost;
    static int[][] sum;

    static void preprocessing() {
        for(int i = 1; i <= N; i++) {
            for(int j = i; j<= N; j++) {
                sum[i][j] = sum[i][j-1] + cost[j];
            }
        }
    }

    static void dynamicProgramming() {
        // DP[i][j] : i ~ j까지 합쳤을 때 최소값.
        preprocessing();
        for(int len = 1; len <= N-1; len++) {
            for(int i = 1; i <= N-len; i++) {
                int j = i + len;
                DP[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k+1][j] + sum[i][j]);
                }
            }
        }
        System.out.println(DP[1][N]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            DP = new int[N+1][N+1];
            sum = new int[N+1][N+1];
            cost = new int[N+1];
            String[] temp = br.readLine().split(" ");
            for(int i = 1; i <= N;i++) {
                cost[i] = Integer.parseInt(temp[i-1]);
            }
            dynamicProgramming();
        }
    }
}
