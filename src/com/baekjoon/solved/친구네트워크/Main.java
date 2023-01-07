package com.baekjoon.solved.친구네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int T;
    static int F;

    static int[] parent;
    static int[] level;

    static int find(int node) {
        if(parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }

    static int union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot) {
            parent[aRoot] = bRoot;
            level[bRoot] += level[aRoot];
        }
        return level[bRoot];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {


            F = Integer.parseInt(br.readLine());
            parent = new int[F * 2 + 1];
            level = new int[F * 2 + 1];

            for(int i = 1; i <= F * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            int cnt = 1;
            HashMap<String, Integer> indexMap = new HashMap<>();
            for(int i = 0; i < F; i++) {

                String[] temp = br.readLine().split(" ");
                String name1 = temp[0];
                if(!indexMap.containsKey(name1)) {
                    indexMap.put(name1, cnt++);
                }

                String name2 = temp[1];
                if(!indexMap.containsKey(name2)) {
                    indexMap.put(name2, cnt++);
                }
                System.out.println(union(indexMap.get(name1), indexMap.get(name2)));
            }
        }
    }
}
