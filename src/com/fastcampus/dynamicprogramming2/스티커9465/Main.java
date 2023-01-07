package com.fastcampus.dynamicprogramming2.스티커9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int N;
    static int[][] dp;
    static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N + 1][2];
            sticker = new int[N + 1][2];
            String[] temp = br.readLine().split(" ");
            String[] temp2 = br.readLine().split(" ");

            for (int i = 1; i <= N; i++) {
                sticker[i][0] = Integer.parseInt(temp[i - 1]);
                sticker[i][1] = Integer.parseInt(temp2[i - 1]);
            }

            dp[1][0] = sticker[1][0];
            dp[1][1] = sticker[1][1];

            if(N >= 2) {
                dp[2][0] = sticker[1][1] + sticker[2][0];
                dp[2][1] = sticker[1][0] + sticker[2][1];

                for (int i = 3; i <= N; i++) {
                    dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + sticker[i][0];
                    dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + sticker[i][1];
                }
            }

            System.out.println(Math.max(Math.max(dp[N][0], dp[N][1]), Math.max(dp[N - 1][0], dp[N - 1][1])));
        }
    }
}
