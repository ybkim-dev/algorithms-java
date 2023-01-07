package com.fastcampus.tree.나무탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N;
    static ArrayList<Integer>[] adj;
    static int result;
    static boolean[] visited;

    static void dfs(int start, int cnt) {
        visited[start] = true;

        for(int y : adj[start]) {
            if(visited[y]) continue;

            if(adj[y].size() == 1) {
                result += (cnt);
            }
            dfs(y, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            String[] temp = br.readLine().split(" ");
            adj[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
            adj[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
        }

        dfs(1, 1);
        if(result % 2 == 1) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}
