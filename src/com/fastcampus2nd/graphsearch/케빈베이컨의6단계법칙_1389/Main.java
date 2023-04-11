package com.fastcampus2nd.graphsearch.케빈베이컨의6단계법칙_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int N, M;
  static ArrayList<Integer>[] adj;
  static boolean[] visited;
  static int[] dist;
  static int ans = 10001;
  static int ansNumber = -1;

  static void bfs(int start) {
    visited = new boolean[N + 1];
    dist = new int[N + 1];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int curr = queue.poll();

      for (int next : adj[curr]) {
        if(visited[next]) continue;
        dist[next] = dist[curr] + 1;
        queue.add(next);
        visited[next] = true;
      }
    }
    int sum = 0;
    for (int i = 1; i <= N; i++) {
      if(i == start) continue;
      sum += dist[i];
    }

    if(sum < ans) {
      ans = sum;
      ansNumber = start;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");

    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    adj = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      int src = Integer.parseInt(temp[0]);
      int dest = Integer.parseInt(temp[1]);
      adj[src].add(dest);
      adj[dest].add(src);
    }

    for (int i = 1; i <= N; i++) {
      bfs(i);
    }

    System.out.println(ansNumber);
  }

}
