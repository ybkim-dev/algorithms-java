package com.fastcampus2nd.dynamicprogramming.일이삼더하기6_15991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int t;
  static long[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    dp = new long[100001];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 2;
    dp[4] = 3;
    dp[5] = 3;
    dp[6] = 6;

    for (int i = 7; i <= 100000; i++) {
      dp[i] = dp[i - 2] + dp[i - 4] + dp[i - 6];
      dp[i] %= 1000000009;
    }

    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(dp[n]);
    }
  }

}
