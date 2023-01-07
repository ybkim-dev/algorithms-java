package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식2156 {
    static int N;
    static int[][] DP;
    static int[] cost;

    static void dynamicProgramming() {
        DP[1][0] = 0;
        DP[1][1] = cost[1];
        if(N >= 2) {
            DP[2][0] = cost[2];
            DP[2][1] = cost[1] + cost[2];
        }
        for(int i = 3; i <= N; i++) {
            DP[i][0] = Math.max(DP[i-2][0], DP[i-2][1]) + cost[i];
            DP[i][0] = Math.max(DP[i][0], Math.max(DP[i-3][0], DP[i-3][1]) + cost[i]);
            DP[i][1] = DP[i-1][0] + cost[i];
        }
        System.out.println(Math.max(Math.max(DP[N][0], DP[N][1]), Math.max(DP[N-1][0], DP[N-1][1])));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][2];
        cost = new int[N+1];
        for(int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        dynamicProgramming();
    }
}
