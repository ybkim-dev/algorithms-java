package com.fastcampus.tree.회사문화114267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int M;
    static int root;

    static ArrayList<Integer>[] workers;
    static int[] good;

    static void dfs(int x) {
        for (int y : workers[x]) {
            good[y] += good[x];
            dfs(y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        good = new int[N + 1];
        workers = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            workers[i] = new ArrayList<>();
        }

        temp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            if(Integer.parseInt(temp[i-1]) == -1) {
                root = i;
                continue;
            }
            workers[Integer.parseInt(temp[i-1])].add(i);
        }

        for (int i = 1; i <= M; i++) {
            temp = br.readLine().split(" ");
            good[Integer.parseInt(temp[0])] += Integer.parseInt(temp[1]);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(good[i]).append(" ");
        }

        System.out.println(sb);
    }
}
