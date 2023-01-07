package com.baekjoon.solved.N과M3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int k) {
        if(k == M+1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            // 중복 가능, 순서 없음 -> 중복 조합
            for (int i = 1; i <= N; i++) {
                selected[k] = i;
                dfs(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        selected = new int[M+1];
        visited = new boolean[N+1];
        dfs(1);

        System.out.println(sb.toString());

    }
}
