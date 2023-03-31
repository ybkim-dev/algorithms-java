package com.fastcampus2nd.graphsearch.유기농배추_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int T;
  static int M, N, K;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if(nx < 0 || nx >= N || ny < 0 | ny >= M) continue;
      if(visited[nx][ny]) continue;
      if(map[nx][ny] == 0) continue;

      dfs(nx, ny);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String[] temp = br.readLine().split(" ");
      M = Integer.parseInt(temp[0]);
      N = Integer.parseInt(temp[1]);
      K = Integer.parseInt(temp[2]);
      map = new int[N][M];
      visited = new boolean[N][M];

      for (int i = 0; i < K; i++) {
        temp = br.readLine().split(" ");
        int y = Integer.parseInt(temp[0]);
        int x = Integer.parseInt(temp[1]);
        map[x][y] = 1;
      }
      int cnt = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (!visited[i][j] && map[i][j] == 1) {
            dfs(i, j);
            cnt++;
          }
        }
      }

      System.out.println(cnt);
    }
  }


}
