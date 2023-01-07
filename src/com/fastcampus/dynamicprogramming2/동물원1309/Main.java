package com.fastcampus.dynamicprogramming2.동물원1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][3];
        //dp[n][0] => n줄에는 동물 넣지 않는 경우
        //dp[n][1] => n줄, 1행에 동물 넣는 경우
        //dp[n][2] => n줄, 2행에 동물 넣는 경우
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        if(N >= 2) {
            for (int i = 2; i <= N; i++) {
                dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
                dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
                dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
            }
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
    }
}
