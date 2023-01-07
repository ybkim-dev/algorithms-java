package com.fastcampus.dynamicprogramming2.오르막수11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) dp[1][i] = 1;
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k <= j; k++) {
                        dp[i][j] += dp[i - 1][k];
                    }
                    dp[i][j] %= 10007;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += (dp[n][i] % 10007);
        }
        System.out.println(ans %= 10007);
    }
}
