package com.fastcampus2nd.shortestpath.최소비용구하기_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
  static int N, M;
  static int[] dist;
  static ArrayList<Edge>[] edges;

  static void dijkstra(int start) {
    PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    pq.add(new Info(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Info info = pq.poll();
      if(dist[info.nodeIdx] < info.cost) continue;

      for(Edge edge : edges[info.nodeIdx]) {
        if(dist[info.nodeIdx] + edge.cost >= dist[edge.to]) continue;
        dist[edge.to] = dist[info.nodeIdx] + edge.cost;
        pq.add(new Info(edge.to, dist[edge.to]));
      }
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    dist = new int[N + 1];
    edges = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      edges[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      String[] temp = br.readLine().split(" ");
      int src = Integer.parseInt(temp[0]);
      int dest = Integer.parseInt(temp[1]);
      int cost = Integer.parseInt(temp[2]);

      edges[src].add(new Edge(dest, cost));
    }


    String[] temp = br.readLine().split(" ");
    int start = Integer.parseInt(temp[0]);
    int target = Integer.parseInt(temp[1]);

    // dijkstra
    for (int i = 1; i <= N; i++) {
      dist[i] = Integer.MAX_VALUE;
    }

    dijkstra(start);
    System.out.println(dist[target]);
  }

  static class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

  static class Info {
    int nodeIdx;
    int cost;

    public Info(int nodeIdx, int cost) {
      this.nodeIdx = nodeIdx;
      this.cost = cost;
    }
  }

}
