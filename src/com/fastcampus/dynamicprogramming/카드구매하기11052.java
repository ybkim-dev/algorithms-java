package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카드구매하기11052 {
    static int[] DP;
    static int[] cost;
    static int N;
    static void dynamicProgramming() {
        for(int i = 0; i < 1000; i++) {
            for(int k = 1; k <= 1000; k++) {
                if((i+k) > 1000) continue;
                DP[i+k] = Math.max(DP[i+k], DP[i] + cost[k]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[1001];
        cost = new int[1001];
        String[] temp =br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(temp[i-1]);
        }
        dynamicProgramming();
        System.out.println(DP[N]);
    }
}
