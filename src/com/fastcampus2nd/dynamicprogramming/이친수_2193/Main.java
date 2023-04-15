package com.fastcampus2nd.dynamicprogramming.이친수_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static long[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    dp = new long[91][2];

    N = Integer.parseInt(br.readLine());

    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i-1][0] + dp[i-1][1];
      dp[i][1] = dp[i - 1][0];
    }

    System.out.println(dp[N][0] + dp[N][1]);
  }

}
