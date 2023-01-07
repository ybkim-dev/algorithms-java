package com.fastcampus.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 음악프로그램2623 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] indegree;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];
        indegree = new int[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            temp = br.readLine().split(" ");
            int time = Integer.parseInt(temp[0]);
            for(int j = 1; j <= time - 1; j++) {
                int source = Integer.parseInt(temp[j]);
                int dest = Integer.parseInt(temp[j+1]);
                adj[source].add(dest);
                indegree[dest]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0 ) {
                queue.add(i);
                visit[i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(" ");
            for(int y : adj[x]) {
                indegree[y]--;
                if(indegree[y] == 0 ) {
                    queue.add(y);
                    visit[y] = true;
                }
            }
        }
        int visitCount = 0;
        for(int i = 1; i <= N; i++) {
            if(visit[i]) visitCount++;
        }
        if(visitCount == N) {
            System.out.println(sb.toString());
        } else {
            System.out.println(0);
        }

    }
}
