package com.fastcampus2nd.tree.노드사이의거리_1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  static int N, M;
  static int[][] weight;
  static int[] dist;
  static boolean[] visited;
  static ArrayList<Integer>[] adj;

  static void dfs(int curr, int target) {
    visited[curr] = true;

    if(curr == target) {
      return;
    }

    for(int next : adj[curr]) {
      if(visited[next]) continue;
      dist[next] = dist[curr] + weight[curr][next];
      dfs(next, target);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    weight = new int[N + 1][N + 1];
    dist = new int[N + 1];
    visited = new boolean[N + 1];
    adj = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      temp = br.readLine().split(" ");
      int src = Integer.parseInt(temp[0]);
      int dest = Integer.parseInt(temp[1]);
      int cost = Integer.parseInt(temp[2]);
      weight[src][dest] = cost;
      weight[dest][src] = cost;

      adj[src].add(dest);
      adj[dest].add(src);
    }

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      int src = Integer.parseInt(temp[0]);
      int dest = Integer.parseInt(temp[1]);
      Arrays.fill(dist, 0);
      Arrays.fill(visited, false);
      dfs(src, dest);
      System.out.println(dist[dest]);
    }

  }

}
