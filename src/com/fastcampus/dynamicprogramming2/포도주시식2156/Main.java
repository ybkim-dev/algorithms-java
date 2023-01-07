package com.fastcampus.dynamicprogramming2.포도주시식2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] A;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        A = new int[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // dp
        dp[1][0] = A[1];
        dp[1][1] = A[1];

        if(n >= 2) {
            dp[2][0] = A[2];
            dp[2][1] = A[1] + A[2];
        }

        if(n >= 3) {
            for (int i = 3; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + A[i];
                dp[i][0] = Math.max(dp[i][0], Math.max(dp[i - 3][0], dp[i - 3][1]) + A[i]);
                dp[i][1] = dp[i - 1][0] + A[i];
            }
        }
        int max = -1;
        for (int i = 1; i <= n; i++) {
            if (max < Math.max(dp[i][0], dp[i][1])) {
                max = Math.max(dp[i][0], dp[i][1]);
            }
        }
        System.out.println(max);
    }
}
