package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 줄어들지않아2688 {
    static int N;
    static long[][] DP;
    static long ans;
    static void dynamicProgramming() {
        for(int j = 0; j < 10; j++) DP[1][j] = 1;
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k <= j; k++) {
                    DP[i][j] += DP[i-1][k];
                }
            }
        }

        for(int j = 0; j <10; j++) {
            ans += DP[N][j];
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            DP = new long[N+1][10];
            ans = 0;
            dynamicProgramming();
        }
    }
}
