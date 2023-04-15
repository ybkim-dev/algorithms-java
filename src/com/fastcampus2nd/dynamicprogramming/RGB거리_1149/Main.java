package com.fastcampus2nd.dynamicprogramming.RGB거리_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[][] color;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    color = new int[1000 + 1][3];
    dp = new int[1001][3];

    for (int i = 1; i <= N; i++) {
      String[] temp = br.readLine().split(" ");
      color[i][0] = Integer.parseInt(temp[0]);
      color[i][1] = Integer.parseInt(temp[1]);
      color[i][2] = Integer.parseInt(temp[2]);
    }

    dp[1][0] = color[1][0];
    dp[1][1] = color[1][1];
    dp[1][2] = color[1][2];

    for (int i = 2; i <= N; i++) {
      dp[i][0] = Math.min(dp[i - 1][1] , dp[i - 1][2] ) + color[i][0];
      dp[i][1] = Math.min(dp[i - 1][0] , dp[i - 1][2] ) + color[i][1];
      dp[i][2] = Math.min(dp[i - 1][0] , dp[i - 1][1] ) + color[i][2];
    }

    int min = 1000001;
    for (int i = 0; i < 3; i++) {
      if(dp[N][i] < min) {
        min = dp[N][i];
      }
    }

    System.out.println(min);
  }

}
