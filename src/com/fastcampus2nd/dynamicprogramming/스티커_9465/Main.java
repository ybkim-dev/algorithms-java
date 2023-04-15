package com.fastcampus2nd.dynamicprogramming.스티커_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int T;
  static int N;
  static int[][] sticker;
  static int[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    while(T-- >0 ){
      N = Integer.parseInt(br.readLine());
      sticker = new int[100000 + 1][2];
      for (int i = 0; i < 2; i++) {
        String[] temp = br.readLine().split(" ");
        for (int j = 0; j < temp.length; j++) {
          sticker[j + 1][i] = Integer.parseInt(temp[j]);
        }
      }

      dp = new int[100000 + 1][2];
      dp[1][0] = sticker[1][0];
      dp[1][1] = sticker[1][1];

      dp[2][0] = sticker[1][1] + sticker[2][0];
      dp[2][1] = sticker[1][0] + sticker[2][1];

      for (int i = 3; i <= N; i++) {
        dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 2][1])) + sticker[i][0];
        dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 2][0], dp[i - 2][1])) + sticker[i][1];
      }

      int max = 0;
      for (int i = 1; i <= N; i++) {
        if(max < Math.max(dp[i][0], dp[i][1])) {
          max = Math.max(dp[i][0], dp[i][1]);
        }
      }

      System.out.println(max);
    }
  }

}
