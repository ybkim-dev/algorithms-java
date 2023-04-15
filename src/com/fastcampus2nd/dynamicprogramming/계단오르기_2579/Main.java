package com.fastcampus2nd.dynamicprogramming.계단오르기_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;
  static int[][] dp;
  static int[] cost;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    dp = new int[300 + 1][2];
    cost = new int[300 + 1];
    for (int i = 0; i < N; i++) {
      cost[i + 1] = Integer.parseInt(br.readLine());
    }

    dp[1][1] = cost[1];
    dp[2][1] = cost[1] + cost[2];
    dp[2][0] = cost[2];

    for (int i = 3; i <= N; i++) {
      dp[i][1] = dp[i - 1][0] + cost[i];
      dp[i][0] = Math.max(dp[i - 2][1], dp[i - 2][0]) + cost[i];
    }

    System.out.println(Math.max(dp[N][0], dp[N][1]));
  }


}
