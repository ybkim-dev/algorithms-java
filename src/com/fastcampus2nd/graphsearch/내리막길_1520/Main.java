package com.fastcampus2nd.graphsearch.내리막길_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int M, N;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int[][] dp;
  static int cnt;

  static int dfs(int x, int y) {
    visited[x][y] = true;

    if(x == M -1 && y == N - 1) return 1;

    if(dp[x][y] != -1) {
      return dp[x][y];
    }

    dp[x][y] = 0;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
      if(visited[nx][ny]) continue;
      if(map[x][y] <= map[nx][ny]) continue;


      dp[x][y] += dfs(nx, ny);
      visited[nx][ny] = false;
    }
    return dp[x][y];
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    M = Integer.parseInt(temp[0]);
    N = Integer.parseInt(temp[1]);

    map = new int[M][N];
    visited = new boolean[M][N];
    dp = new int[M][N];
    for (int i = 0; i < M; i++) {
      Arrays.fill(dp[i], -1);
    }


    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(temp[j]);
      }
    }

    int ans = dfs(0, 0);

    System.out.println(ans);
  }

}
