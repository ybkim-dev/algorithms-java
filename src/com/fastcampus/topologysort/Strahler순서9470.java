package com.fastcampus.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Strahler순서9470 {
    static int[] strahler;
    static int[] max;
    static int[] maxCnt;
    static ArrayList<Integer>[] adj;
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] temp = br.readLine().split(" ");
            int k = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int p = Integer.parseInt(temp[2]);
            strahler = new int[m+1];
            max = new int[m+1];
            maxCnt = new int[m+1];
            adj = new ArrayList[m+1];
            indegree = new int[m+1];
            for(int i = 1; i <= m; i++) {
                adj[i] = new ArrayList<>();
            }
            for(int i = 1; i <= p; i++) {
                temp = br.readLine().split(" ");
                int source = Integer.parseInt(temp[0]);
                int dest = Integer.parseInt(temp[1]);
                adj[source].add(dest);
                indegree[dest]++;
            }

            // topology sort
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i<=m; i++) {
                if(indegree[i] == 0) {
                    queue.add(i);
                    strahler[i] = 1;
                }
            }

            while(!queue.isEmpty()) {
                int x = queue.poll();
                for(int y : adj[x]) {
                    if(max[y] < strahler[x]) {
                        maxCnt[y] = 1;
                        max[y] = strahler[x];
                    } else if(max[y] == strahler[x]) {
                        maxCnt[y]++;
                        max[y] = strahler[x];
                    }
                    indegree[y]--;
                    if(indegree[y] == 0) {
                        if(maxCnt[y] <= 1) {
                            strahler[y] = max[y];
                        } else strahler[y] = (max[y] + 1);
                        queue.add(y);
                    }
                }
            }

            int answer = 0;
            for(int i = 1; i <=m;i++) {
                if(answer < strahler[i]) {
                    answer = strahler[i];
                }
            }
            System.out.println(k + " " + answer);
        }
    }
}
