package com.fastcampus.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 최소비용구하기1916Temp {
    static class Info {
        int idx;
        int cost;
        public Info() {  }

        public Info(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static class Edge {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    static int N, M;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void dijkstra(int start) {
        for(int i = 1;i<=N; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.cost));
        pq.add(new Info(start, 0));

        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if(dist[info.idx] < info.cost) continue;

            for(Edge edge : edges[info.idx]) {
                if(dist[info.idx] + edge.cost >= dist[edge.dest]) continue;
                dist[edge.dest] = dist[info.idx] + edge.cost;
                pq.add(new Info(edge.dest, dist[edge.dest]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        edges = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++) {
            temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            int weight = Integer.parseInt(temp[2]);
            edges[start].add(new Edge(dest,weight));
        }
        temp = br.readLine().split(" ");
        int start = Integer.parseInt(temp[0]);
        int dest = Integer.parseInt(temp[1]);
        dijkstra(start);
        System.out.println(dist[dest]);
    }
}
