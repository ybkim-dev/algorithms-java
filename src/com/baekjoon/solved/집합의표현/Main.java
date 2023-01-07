package com.baekjoon.solved.집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] parent;

    static int find(int node) {
        if(parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        parent = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= M; i++) {
            temp = br.readLine().split(" ");
            int command = Integer.parseInt(temp[0]);
            int a = Integer.parseInt(temp[1]);
            int b = Integer.parseInt(temp[2]);
            if(command == 0) {
                union(a,b);
            } else if(command == 1) {
                if(find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
