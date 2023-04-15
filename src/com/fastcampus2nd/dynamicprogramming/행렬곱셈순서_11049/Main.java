package com.fastcampus2nd.dynamicprogramming.행렬곱셈순서_11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[][] dp;
  static Matrix[] matrices;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    matrices = new Matrix[N + 1];
    dp = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      String[] temp = br.readLine().split(" ");
      int row = Integer.parseInt(temp[0]);
      int col = Integer.parseInt(temp[1]);
      matrices[i] = new Matrix(row, col);
    }

    for (int len = 2; len <= N; len++) {
      for (int i = 1; i <= N - len + 1; i++) {
        int j = i + len - 1;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
          dp[i][j] = Math.min(dp[i][j],
              dp[i][k] + dp[k + 1][j] + matrices[i].row * matrices[k + 1].row * matrices[j].col);
        }
      }
    }

    System.out.println(dp[1][N]);
  }

  static class Matrix {
    int row;
    int col;

    public Matrix(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

}
