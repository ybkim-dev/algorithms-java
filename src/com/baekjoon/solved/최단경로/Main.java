package com.baekjoon.solved.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static int V, E, K;
    static int[] dist;
    static ArrayList<Edge>[] adj;

    static void dijkstra(int start) {
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        priorityQueue.add(new Info(start, 0));
        dist[start] = 0;
        while(!priorityQueue.isEmpty()) {
            Info info = priorityQueue.poll();
            if(dist[info.nodeId] < info.cost) continue;
            for(Edge adjEdge : adj[info.nodeId]) {
                if(dist[info.nodeId] + adjEdge.cost >= dist[adjEdge.dest]) continue;
                dist[adjEdge.dest] = dist[info.nodeId] + adjEdge.cost;
                priorityQueue.add(new Info(adjEdge.dest, dist[adjEdge.dest]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        V = Integer.parseInt(temp[0]);
        E = Integer.parseInt(temp[1]);
        K = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        dist = new int[V + 1];

        for(int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++) {
            temp = br.readLine().split(" ");
            int source = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            int weight = Integer.parseInt(temp[2]);
            adj[source].add(new Edge(dest, weight));
        }

        dijkstra(K);

        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }
}

class Edge {
    int dest;
    int cost;

    public Edge(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

class Info {
    int nodeId;
    int cost;

    public Info(int nodeId, int cost) {
        this.nodeId = nodeId;
        this.cost = cost;
    }
}