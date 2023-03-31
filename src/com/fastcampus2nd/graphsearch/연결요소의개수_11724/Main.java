package com.fastcampus2nd.graphsearch.연결요소의개수_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[][] map;
  static boolean[] visited;

  static void dfs(int x) {
    visited[x] = true;

    for(int i = 1; i <= N; i++) {
      if(map[x][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);
    map = new int[N + 1][N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      int u = Integer.parseInt(temp[0]);
      int v = Integer.parseInt(temp[1]);
      map[u][v] = 1;
      map[v][u] = 1;
    }
    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if(!visited[i]) {
        dfs(i);
        cnt++;
      }
    }

    System.out.println(cnt);
  }

}
