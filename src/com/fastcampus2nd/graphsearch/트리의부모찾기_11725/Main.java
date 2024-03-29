package com.fastcampus2nd.graphsearch.트리의부모찾기_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int N;
  static ArrayList<Integer>[] adj;
  static boolean[] visited;
  static int[] parent;

  static void dfs(int curr) {
    visited[curr] = true;

    for(int adjacent : adj[curr]) {
      if(visited[adjacent]) continue;
      parent[adjacent] = curr;
      dfs(adjacent);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    adj = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    parent = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      String[] temp = br.readLine().split(" ");
      int start = Integer.parseInt(temp[0]);
      int end = Integer.parseInt(temp[1]);
      adj[start].add(end);
      adj[end].add(start);
    }

    dfs(1);
    for (int i = 2; i <= N; i++) {
      System.out.println(parent[i]);
    }


  }

}
