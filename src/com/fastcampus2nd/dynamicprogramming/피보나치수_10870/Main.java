package com.fastcampus2nd.dynamicprogramming.피보나치수_10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int n;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    dp = new int[21];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;

    for (int i = 3; i <= 20; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    n = Integer.parseInt(br.readLine());
    System.out.println(dp[n]);
  }

}
