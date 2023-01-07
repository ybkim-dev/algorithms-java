package com.fastcampus.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 게임개발1516 {
    static int[] cost;
    static int[] max;
    static ArrayList<Integer>[] adj;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N+1];
        max = new int[N+1];
        indegree = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split(" ");
            for(int j = 0; j < temp.length; j++) {
                int info = Integer.parseInt(temp[j]);
                if(j == 0) {
                    cost[i] = info;
                } else {
                    if(info==-1) break;
                    adj[info].add(i);
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> queue =new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indegree[i] ==0 ){
                queue.add(i);
                max[i] = cost[i];
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int y : adj[node]) {
                indegree[y]--;
                if(indegree[y] == 0) queue.add(y);
                max[y] = Math.max(max[y], max[node] + cost[y]);
            }
        }
        for(int i = 1; i <= N; i++) {
            System.out.println(max[i]);
        }
    }
}
