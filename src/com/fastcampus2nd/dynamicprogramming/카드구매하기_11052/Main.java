package com.fastcampus2nd.dynamicprogramming.카드구매하기_11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] cost;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    dp = new int[1001];
    cost = new int[N + 1];

    String[] temp = br.readLine().split(" ");
    for (int j = 1; j <= N; j++) {
      cost[j] = Integer.parseInt(temp[j - 1]);
    }

    for (int i = 0; i < 1000; i++) {
      for (int k = 1; i + k <= N; k++) {
        dp[i + k] = Math.max(dp[i + k], dp[i] + cost[k]);
      }
    }

    System.out.println(dp[N]);
  }

}
