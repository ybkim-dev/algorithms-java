package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단수1562 {
    static int[][][][] DP;
    static int ans;
    static int N;
    static int mod = 1000000000;
    static void dynamicProgramming() {
        for(int i = 1; i <= 9; i++) {
            DP[1][i][i][i] = 1;
        }

        for(int len = 2; len <= N; len++) {
            for(int prev = 0; prev <= 9; prev++) {
                for(int low=0; low <= 9; low++) {
                    for(int high=0; high <= 9; high++) {
                        for(int cur : new int[] {prev -1 , prev +1}) {
                            if(cur <0 || cur > 9) continue;
                            DP[len][cur][Math.min(low, cur)][Math.max(high, cur)] +=
                                    DP[len-1][prev][low][high];
                            DP[len][cur][Math.min(low, cur)][Math.max(high, cur)] %= mod;
                        }
                    }
                }
            }
        }

        for(int i = 0; i <= 9; i++) {
            ans += DP[N][i][0][9];
            ans %= mod;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][10][10][10]; // 글자수, 마지막으로 추가된 숫자, 포함된 숫자의 최소, 최대
        dynamicProgramming();
    }
}
