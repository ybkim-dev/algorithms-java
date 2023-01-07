package com.fastcampus.tree.노드사이의거리1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;

    static int[] dist;
    static ArrayList<Edge>[] adj;
    static boolean[] visited;

    static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N-1; i++) {
            temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int weight = Integer.parseInt(temp[2]);

            adj[start].add(new Edge(end, weight));
            adj[end].add(new Edge(start, weight));
        }

        for (int i = 1; i <= M; i++) {
            temp = br.readLine().split(" ");
            Arrays.fill(dist, 0);
            Arrays.fill(visited, false);
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);

            int result = bfs(start, end);
            System.out.println(result);
        }



    }

    static int bfs(int start, int end) {
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;
        while (!queue.isEmpty()) {
            Integer x = queue.poll();

            if(x == end) {
                return dist[x];
            }
            for(Edge y : adj[x]) {
                if(visited[y.dest]) continue;
                visited[y.dest] = true;
                dist[y.dest] = dist[x] + y.weight;
                queue.add(y.dest);
            }
        }
        return 0;
    }
}
