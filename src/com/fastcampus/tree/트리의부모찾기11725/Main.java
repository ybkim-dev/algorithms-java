package com.fastcampus.tree.트리의부모찾기11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N;

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] parent;

    static void dfs(int start) {
        visited[start] = true;

        for(int y : adj[start]) {
            if(visited[y]) continue;
            parent[y] = start;
            dfs(y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < N- 1; i++) {
            String[] temp = br.readLine().split(" ");
            adj[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
            adj[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
        }

        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
