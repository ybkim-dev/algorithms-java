package com.fastcampus.shortestpath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    static int[] dist;
    static int N;
    static ArrayList<Edge>[] edges;

    static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if(dist[info.nodeIdx] < info.dist) continue;
            for (Edge edge : edges[info.nodeIdx]) {
                if(dist[info.nodeIdx] + edge.weight >= dist[edge.dest]) continue;

                dist[edge.dest] = dist[info.nodeIdx] + edge.weight;
                pq.add(new Info(edge.dest, dist[edge.dest]));
            }
        }
    }
}

class Info {
    int nodeIdx;
    int dist;

    public Info(int nodeIdx, int dest) {
        this.nodeIdx = nodeIdx;
        this.dist = dest;
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