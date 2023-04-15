package com.fastcampus2nd.dynamicprogramming.피보나치함수_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int t;
  static int n;
  static int[][] dp;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());

    dp = new int[41][2];
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 2; i <= 40; i++) {
      dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
      dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
    }

    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());
      sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
    }

    System.out.println(sb);
  }

}
