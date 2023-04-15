package com.fastcampus2nd.dynamicprogramming.일이삼더하기_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int n,t;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());

    dp = new int[12];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i <= 11; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    while(t-- > 0) {
      n = Integer.parseInt(br.readLine());
      System.out.println(dp[n]);
    }

  }

}
