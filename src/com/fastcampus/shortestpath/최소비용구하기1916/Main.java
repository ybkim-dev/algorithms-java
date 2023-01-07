package com.fastcampus.shortestpath.최소비용구하기1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static int M;
    static ArrayList<Edge>[] edges;
    static int[] dist;

    static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if(dist[info.nodeIdx] < info.cost) continue;

            for (Edge edge : edges[info.nodeIdx]) {
                if(dist[info.nodeIdx] + edge.weight >= dist[edge.dest]) continue;
                dist[edge.dest] = dist[info.nodeIdx] + edge.weight;
                pq.add(new Info(edge.dest, dist[edge.dest]));
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
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int weight = Integer.parseInt(temp[2]);

            edges[start].add(new Edge(end, weight));
        }

        String[] temp = br.readLine().split(" ");
        int start = Integer.parseInt(temp[0]);
        int end = Integer.parseInt(temp[1]);

        // dijkstra(start)
        dijkstra(start);
        System.out.println(dist[end]);

    }

}

class Edge {
    int dest;
    int weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

class Info {
    int nodeIdx;
    int cost;

    public Info(int nodeIdx, int cost) {
        this.nodeIdx = nodeIdx;
        this.cost = cost;
    }
}
