package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기15988 {
    static int T, n;
    static int[] DP;

    static void dynamicProgramming() {
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        int mod = 1000000009;
        for(int i = 4; i <= 1000000; i++) {
            DP[i] = DP[i-1];
            DP[i] += DP[i-2];
            DP[i] %= mod;
            DP[i] += DP[i-3];
            DP[i] %= mod;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        DP = new int[1000001];
        dynamicProgramming();
        for(int t= 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(DP[n]);
        }
    }
}
