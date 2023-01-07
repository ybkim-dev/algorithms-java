package com.fastcampus.graphsearch.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] adj;

    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        V = Integer.parseInt(temp[2]);
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            // array list 초기화
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            // 간선 추가
            temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            adj[start].add(end);
            adj[end].add(start);
        }

        for(int i = 1; i <= N ; i++) {
            Collections.sort(adj[i]);
        }

        // dfs call
        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        // bfs call
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb.toString());
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            // 1. 큐에서 꺼내옴
            int x = queue.poll();
            // 2. 목적지인가?
            sb.append(x).append(" ");
            // 3. 연결된 곳을 순회
            for(int y : adj[x]) {
                // 4. 갈 수 있는가?
                if(visited[y] == true) continue;
                // 5. 체크인
                visited[y] = true;
                // 6. 큐에 넣음
                queue.add(y);
            }

        }

    }


    static void dfs(int x) {
        // 1. 체크인
        visited[x] = true;
        // 2. 목적지인가? // 어차피 다 순회할 거라서 없어도 됨.
        sb.append(x).append(" ");
        // 3. 인접한가?
        for(int y : adj[x]) {
            // 4. 갈 수 있는가?
            if(visited[y] == true) continue;
            // 5. 간다.
            dfs(y);
        }
    }

}
