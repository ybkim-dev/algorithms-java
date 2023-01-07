package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오르막수11057 {
    static int N;
    static int[][] DP;
    static int ans;
    static void dynamicProgramming() {
        for(int j = 0; j < 10; j++) DP[1][j] = 1;
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    if(j >= k) {
                        DP[i][j] += DP[i-1][k];
                        DP[i][j] %= 10007;
                    }
                }
            }
        }

        for(int j = 0; j <10; j++) {
            ans += DP[N][j];
        }
        ans %= 10007;
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][10];
        dynamicProgramming();
    }
}
