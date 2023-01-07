package com.fastcampus.shortestpath.최단경로1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int V, E;
    static long[] dist;
    static ArrayList<Edge>[] edges;

    static void dijkstra(int start) {
        for (int i = 1; i <= V; i++) dist[i] = Long.MAX_VALUE;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.cost));
        dist[start] = 0;
        pq.add(new Info(start, 0));

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
        String[] temp = br.readLine().split(" ");
        V = Integer.parseInt(temp[0]);
        E = Integer.parseInt(temp[1]);

        dist = new long[V + 1];
        edges = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) edges[i] = new ArrayList<>();


        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            temp = br.readLine().split(" ");
            int source = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            int weight = Integer.parseInt(temp[2]);
            edges[source].add(new Edge(dest, weight));
        }

        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(dist[i] == Long.MAX_VALUE) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }

        System.out.println(sb);
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
    long cost;

    public Info(int nodeIdx, long cost) {
        this.nodeIdx = nodeIdx;
        this.cost = cost;
    }
}