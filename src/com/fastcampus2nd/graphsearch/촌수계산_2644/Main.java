package com.fastcampus2nd.graphsearch.촌수계산_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int N, M;
  static ArrayList<Integer>[] adj;
  static int[] dist;

  static void bfs(int start, int target) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    dist[start] = 0;

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      for(int adjacent : adj[curr]) {
        if(dist[adjacent] > -1) continue;
        dist[adjacent] = dist[curr] + 1;
        if(adjacent == target) break;
        queue.add(adjacent);
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    String[] temp = br.readLine().split(" ");
    int start = Integer.parseInt(temp[0]);
    int target = Integer.parseInt(temp[1]);

    M = Integer.parseInt(br.readLine());
    adj = new ArrayList[N + 1];
    dist = new int[N + 1];
    for(int i = 1; i <= N; i++) {
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
      dist[i] = -1;
    }

    bfs(start, target);
    System.out.println(dist[target]);
  }

}
