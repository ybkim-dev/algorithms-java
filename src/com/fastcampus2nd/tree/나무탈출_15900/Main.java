package com.fastcampus2nd.tree.나무탈출_15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int N;
  static ArrayList<Integer>[] adj;
  static int[] dist;
  static boolean[] visited;
  static int ans;

  static void dfs(int curr) {
    visited[curr] = true;

    if(curr != 1 && adj[curr].size() == 1) {
      // leaf 노드라면
      ans += dist[curr];
    }

    for(int next : adj[curr]) {
      if(visited[next]) continue;
      dist[next] = dist[curr] + 1;
      dfs(next);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    adj = new ArrayList[N + 1];
    dist = new int[N + 1];
    visited = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      String[] temp = br.readLine().split(" ");
      int src = Integer.parseInt(temp[0]);
      int dest = Integer.parseInt(temp[1]);
      adj[src].add(dest);
      adj[dest].add(src);
    }

    dfs(1);
    if (ans % 2 == 0) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }

}
