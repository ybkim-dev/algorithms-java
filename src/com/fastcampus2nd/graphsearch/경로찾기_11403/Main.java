package com.fastcampus2nd.graphsearch.경로찾기_11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int N;
  static int[][] map;
  static boolean[] visited;
  static ArrayList<Integer>[] adj;

  static void dfs(int node, int index) {
    if(index != 0) {
      visited[node] = true;
    }
    for(int adj : adj[node]) {
      if(visited[adj]) continue;
      dfs(adj, index + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    adj = new ArrayList[N];

    for (int i = 0; i < N; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      String[] temp = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(temp[j]);
        if(map[i][j] == 1) {
          adj[i].add(j);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      visited = new boolean[N];
      dfs(i, 0);
      for(int j = 0; j < N; j++) {
        if(visited[j]) sb.append(1);
        else sb.append(0);
        sb.append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

}
