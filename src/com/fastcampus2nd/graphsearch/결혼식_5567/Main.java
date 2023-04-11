package com.fastcampus2nd.graphsearch.결혼식_5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int n, m;
  static ArrayList<Integer>[] adj;
  static boolean[] visited;
  static int[] dist;
  static int cnt;

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int curr = queue.poll();

      for(int next : adj[curr]) {
        if(visited[next]) continue;
        dist[next] = dist[curr] + 1;
        queue.add(next);
        visited[next] = true;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    adj = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    dist = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      String[] temp = br.readLine().split(" ");
      int src = Integer.parseInt(temp[0]);
      int dest = Integer.parseInt(temp[1]);
      adj[src].add(dest);
      adj[dest].add(src);
    }

    bfs(1);

    for (int i = 2; i <= n; i++) {
      if(dist[i] <= 2 && dist[i] > 0) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }

}
