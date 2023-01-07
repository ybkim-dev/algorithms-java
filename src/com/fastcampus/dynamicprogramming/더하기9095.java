package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기9095 {
    static int T, n;
    static int[] DP;

    static void dynamicProgramming() {
        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                DP[i] = 1;
            } else if(i == 2) {
                DP[i] = DP[i-1] + 1;
            } else if(i == 3) {
                DP[i] = DP[i-1] + DP[i-2] + 1;
            } else {
                DP[i] = DP[i-3] + DP[i-2] + DP[i-1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t= 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            DP = new int[n+1];
            dynamicProgramming();
            System.out.println(DP[n]);
        }
    }
}
