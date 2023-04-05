package com.fastcampus2nd.graphsearch.바이러스_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int N;
  static int M;
  static ArrayList<Integer>[] adj;
  static boolean[] visited;
  static int cnt;

  static void search(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      cnt++;

      for(int adjacent : adj[node]) {
        if(visited[adjacent]) continue;
        queue.add(adjacent);
        visited[adjacent] = true;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    adj = new ArrayList[N + 1];
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      String[] temp = br.readLine().split(" ");
      int start = Integer.parseInt(temp[0]);
      int end = Integer.parseInt(temp[1]);

      adj[start].add(end);
      adj[end].add(start);
    }

    search(1);
    System.out.println(cnt - 1);
  }

}
