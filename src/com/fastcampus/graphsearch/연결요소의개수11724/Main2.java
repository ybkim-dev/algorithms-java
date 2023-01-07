package com.fastcampus.graphsearch.연결요소의개수11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    static int N;
    static int M;

    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++ ) {
            temp = br.readLine().split(" ");
            adj[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
            adj[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
        }
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(visited[i] == false) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int x = queue.poll();

            for(int y : adj[x]) {
                if(visited[y] == true) continue;
                visited[y] = true;
                queue.add(y);
            }
        }
    }
}
