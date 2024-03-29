package com.fastcampus2nd.dynamicprogramming.파일합치기_11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int T;
  static int K;
  static int[] A;
  static int[][] sum;
  static long[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      K = Integer.parseInt(br.readLine());
      String[] temp = br.readLine().split(" ");

      sum = new int[501][501];
      dp = new long[501][501];
      A = new int[K + 1];
      for (int i = 1; i <= temp.length; i++) {
        A[i] = Integer.parseInt(temp[i - 1]);
      }

      // sum 채우기
      for (int i = 1; i <= K; i++) {
        for (int j = i; j <= K; j++) {
          sum[i][j] = sum[i][j - 1] + A[j];
        }
      }

      // dp 채우기
      for (int len = 2; len <= K; len++) {
        for(int i = 1; i <= K - len + 1; i++ ) {
          int j = i + len - 1;
          dp[i][j] = Integer.MAX_VALUE;

          for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[i][j]);
          }
        }
      }

      System.out.println(dp[1][K]);
    }
  }

}
