package com.baekjoon.solved.여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] parent;

    static int find(int node) {
        if(node == parent[node]) return node;
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

        temp = br.readLine().split(" ");
        M = Integer.parseInt(temp[0]);

        parent = new int[N + 1];

        for(int i=1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            temp = br.readLine().split(" ");
            for(int j = 1; j <= N; j++) {
                if(Integer.parseInt(temp[j-1]) == 1) {
                    union(i,j);
                }
            }
        }

        temp = br.readLine().split(" ");
        boolean isPossible = true;
        int parentNode = find(Integer.parseInt(temp[0]));
        for(int i = 1; i < M; i++) {
            if (parentNode != find(Integer.parseInt(temp[i]))) {
                isPossible = false;
                break;
            }
        }

        if(isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
