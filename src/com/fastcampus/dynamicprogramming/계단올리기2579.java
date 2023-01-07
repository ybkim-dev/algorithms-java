package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단올리기2579 {
    static int N;
    static int[] DP;
    static int[] cost;

    static void dynamicProgramming() {
        DP[1] = cost[1];
        DP[2] = cost[1] + cost[2];
        for(int i = 3; i <= 300; i++) {
            DP[i] = Math.max(DP[i-3] + cost[i-1] + cost[i] , DP[i-2] + cost[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[301];
        cost = new int[301];
        for(int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        dynamicProgramming();
        System.out.println(DP[N]);
    }
}
