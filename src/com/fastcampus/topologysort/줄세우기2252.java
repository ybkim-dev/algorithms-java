package com.fastcampus.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 줄세우기2252 {
    static int N,M;
    static ArrayList<Integer>[] adj;
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        adj = new ArrayList[N+1];
        indegree = new int[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i< M; i++) {
            temp = br.readLine().split(" ");
            int source = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            adj[source].add(dest);
            indegree[dest]++;
        }
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            // indegree 0 인 것 찾기.
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            for(int dest : adj[node]) {
                indegree[dest]--;
                if(indegree[dest] == 0) {
                    queue.add(dest);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
