package com.fastcampus.graphsearch.바이러스;

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

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (Integer next : adj[cur]) {
                if(visited[next]) continue;
                cnt++;
                visited[next] = true;
                queue.add(next);
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
            adj[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
            adj[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
        }

        bfs(1);
        System.out.println(cnt);
    }
}
