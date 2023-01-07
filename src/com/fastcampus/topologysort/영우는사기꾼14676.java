package com.fastcampus.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 영우는사기꾼14676 {
    static int[] indegree;
    static int[] cnt;
    static int[] satisfy;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n,m,k;
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        k = Integer.parseInt(temp[2]);
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        cnt = new int[n+1];
        indegree = new int[n+1];
        satisfy = new int[n+1];
        for(int i = 1; i <= m; i++) {
            temp = br.readLine().split(" ");
            int source = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            adj[source].add(dest);
            indegree[dest]++;
        }
        boolean lie = false;
        while(k-- > 0) {
            temp = br.readLine().split(" ");
            int t = Integer.parseInt(temp[0]);
            int node = Integer.parseInt(temp[1]);
            if(t == 1) { // 건설.
                if(satisfy[node] < indegree[node]) {
                    lie = true;
                }
                cnt[node]++;
                if(cnt[node] == 1) {
                    for(int y : adj[node]) {
                        satisfy[y]++;
                    }
                }
            } else {    // 파괴.
                if(cnt[node] == 0) {
                    lie = true;
                }
                cnt[node]--;
                if(cnt[node] == 0) {
                    for(int y : adj[node]) {
                        satisfy[y]--;
                    }
                }
            }
        }
        if(lie) {
            System.out.println("Lier!");
        } else {
            System.out.println("King-God-Emperor");
        }
    }
}
