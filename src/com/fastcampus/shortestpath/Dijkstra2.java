package com.fastcampus.shortestpath;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra2{
    static int N;
    static int M;

    static class Edge{
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
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

    static int[] dist;

    static ArrayList<Edge>[] edges;

    static void dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Info(start, 0));

        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if(dist[info.nodeIdx] < info.cost) continue;

            for(Edge edge : edges[info.nodeIdx]) {
                // edge 타고 다음 노드로 가는 비용이 원래 edge타고 가는 거보다 더 비싸면 추가 안함.
                if(dist[info.nodeIdx] + edge.cost >= dist[edge.dest]) continue;
                dist[edge.dest] = dist[info.nodeIdx] + edge.cost;
                pq.add(new Info(edge.dest, dist[edge.dest]));
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        temp = br.readLine().split(" ");
        M = Integer.parseInt(temp[0]);

        dist = new int[N+1];
        edges = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            edges[i] = new ArrayList<>();
        }
        // Edge 추가.
        for(int i = 1; i <= M; i++) {
            temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int cost = Integer.parseInt(temp[2]);
            edges[start].add(new Edge(end, cost));
        }

        temp = br.readLine().split(" ");
        int startNode = Integer.parseInt(temp[0]);
        int endNode = Integer.parseInt(temp[1]);
        // dist 초기화.
        for(int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dijkstra(startNode);

        System.out.println(dist[endNode]);

    }
}


