package com.fastcampus2nd.dynamicprogramming.포도주시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int n;
  static int[][] dp;
  static int[] cost;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    dp = new int[10001][2];
    cost = new int[10001];

    for (int i = 1; i <= n; i++) {
      cost[i] = Integer.parseInt(br.readLine());
    }

    dp[1][0] = cost[1];
    dp[1][1] = cost[1];

    dp[2][0] = cost[2];
    dp[2][1] = cost[1] + cost[2];

    for (int i = 3; i <= n; i++) {
      dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + cost[i];
      dp[i][0] = Math.max(dp[i][0], Math.max(dp[i - 3][0], dp[i - 3][1]) + cost[i]);
      dp[i][1] = dp[i - 1][0] + cost[i];
    }
    int max = 0;
    for (int i = 1; i <= n; i++) {
      int candidate = Math.max(dp[i][0], dp[i][1]);
      if(candidate > max) {
        max = candidate;
      }
    }
    System.out.println(max);
  }

}
