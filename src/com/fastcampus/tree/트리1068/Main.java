package com.fastcampus.tree.트리1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N;
    static ArrayList<Integer>[] child;
    static int root, erased;
    static int[] leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        child = new ArrayList[N];
        leaf = new int[N];
        for (int i = 0; i < N; i++) {
            child[i] = new ArrayList<>();
        }
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int par = Integer.parseInt(temp[i]);
            if(par == -1) {
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = Integer.parseInt(br.readLine());

        pro();

    }

    static void dfs(int x) {
        if (child[x].isEmpty()) {
            leaf[x] = 1;
        }
        for(int y : child[x]) {
            dfs(y);
            leaf[x] += leaf[y];
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            if(child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
            }
        }
        if(root != erased) {
            dfs(root);
        }
        System.out.println(leaf[root]);
    }
}
