package com.fastcampus.graphsearch.경로찾기11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] map;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    static void bfs(int start) {
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();

            for (Integer next : adj[curr]) {
                if(visited[next]) continue;
                visited[next] = true;
                queue.add(next);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i] ? 1 : 0).append(" ");
        }
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(temp[j - 1]);
                if(Integer.parseInt(temp[j-1]) == 1) {
                    adj[i].add(j);
                }
            }
        }


        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        System.out.println(sb.toString());
    }
}
