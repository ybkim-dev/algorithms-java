package com.fastcampus2nd.dynamicprogramming.줄어들지않아_2688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int T;
  static int n;
  static long[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    dp = new long[65][10];

    for (int i = 0; i < 10; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= 64; i++) {
      for(int j = 0; j <= 9; j++) {
        for (int k = 0; k <= j; k++) {
          dp[i][j] += dp[i-1][k];
        }
      }
    }

    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      n = Integer.parseInt(br.readLine());
      long ans = 0;
      for (int i = 0; i <= 9; i++) {
        ans += dp[n][i];
      }
      System.out.println(ans);
    }
  }

}
