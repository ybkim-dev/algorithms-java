package com.fastcampus.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ACMCraft1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);
            int[] cost = new int[n+1];
            temp = br.readLine().split(" ");
            for(int i = 1; i <= n; i++) {
                cost[i] = Integer.parseInt(temp[i-1]);
            }
            ArrayList<Integer>[] adj = new ArrayList[n+1];
            for(int i =1 ; i<=n;i++) {
                adj[i] = new ArrayList<>();
            }
            int[] indegree = new int[n+1];
            int[] max = new int[n+1];

            for(int i = 1; i <= k; i++) {
                temp = br.readLine().split(" ");
                int source = Integer.parseInt(temp[0]);
                int dest = Integer.parseInt(temp[1]);
                adj[source].add(dest);
                indegree[dest]++;
            }
            int w = Integer.parseInt(br.readLine());
            // start.
            Queue<Integer> queue = new LinkedList<>();
            for(int i =1; i <=n;i++) {
                if(indegree[i] ==0 ){
                    queue.add(i);
                    max[i] = cost[i];
                }
            }
            int ans = 0;
            while(!queue.isEmpty()) {
                int node = queue.poll();
                for(int y : adj[node]) {
                    if(max[y] < cost[node]) {
                        max[y] = cost[node];
                    }
                    indegree[y]--;
                    if(indegree[y] ==0 ){
                        cost[y] += max[y];
                        queue.add(y);
                    }
                }
            }
            System.out.println(cost[w]);
        }
    }
}
