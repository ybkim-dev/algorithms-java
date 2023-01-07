package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기15991 {
    static int T;
    static int[] DP;
    static int mod = 1000000009;

    static void dynamicProgramming() {
        DP[1] = 1; DP[2] = 2; DP[3] = 2; DP[4] = 3; DP[5] = 3; DP[6] = 6;
        for(int i = 7; i <= 100000; i++) {
            DP[i] = DP[i-2];
            DP[i] %= mod;
            DP[i] += DP[i-4];
            DP[i] %= mod;
            DP[i] += DP[i-6];
            DP[i] %= mod;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DP = new int[100001];
        T = Integer.parseInt(br.readLine());
        dynamicProgramming();
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(DP[n]);
        }

    }

}
