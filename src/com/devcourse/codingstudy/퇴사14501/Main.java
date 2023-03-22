package com.devcourse.codingstudy.퇴사14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int[][] calendar;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        calendar = new int[N+1][2];
        String[] temp;
        for (int i = 1; i <= N; i++) {
            temp = br.readLine().split(" ");
            calendar[i][0] = Integer.parseInt(temp[0]);
            calendar[i][1] = Integer.parseInt(temp[1]);
        }
        dp = new int[N + 1];
        if(calendar[1][0] == 1) dp[1] = calendar[1][1];

        for (int i = 2; i <= N; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                // 과거에 시작해서 현재에 끝나는 일 or 현재에 시작해서 현재에 끝나는 일
                if (j + calendar[j][0] - 1 == i && max < dp[j] + calendar[j][1]) {
                    max = dp[j] + calendar[j][1];
                }
            }
            dp[i] = max;
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
            }
        }
        System.out.println(ans);
    }
}
