package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스티커9465 {
    static int T;
    static int n;
    static int[][] DP;
    static int[][] cost;
    static int ans;

    static void dynamicProgramming() {
        DP[0][0] = cost[0][0];
        DP[1][0] = cost[1][0];
        if(n >= 2) {
            DP[0][1] = DP[1][0] + cost[0][1];
            DP[1][1] = DP[0][0] + cost[1][1];
        }
        for(int j = 2; j < n; j++) {
            for(int i = 0; i < 2; i++) {
                if(i == 0) {
                    DP[i][j] = Math.max(Math.max(DP[1][j-1], DP[0][j-2]), DP[1][j-2]) + cost[i][j];
                } else {
                    DP[i][j] = Math.max(Math.max(DP[0][j - 1], DP[1][j - 2]), DP[0][j - 2]) + cost[i][j];
                }
            }
        }
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, DP[i][j]);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            cost = new int[2][n];
            DP = new int[2][n];
            ans = 0;
            for(int i = 0; i < 2; i++) {
                String[] temp = br.readLine().split(" ");
                for(int j =0; j < n; j++) {
                    cost[i][j] = Integer.parseInt(temp[j]);
                }
            }
            dynamicProgramming();
        }
    }
}
