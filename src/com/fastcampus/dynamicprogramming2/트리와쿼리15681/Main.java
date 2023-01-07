package com.fastcampus.dynamicprogramming2.트리와쿼리15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N, R, Q;
    static int[] dp;
    static ArrayList<Integer>[] con;

    static void dfs(int x, int prev) {
        dp[x] = 1;
        for (int y : con[x]) {
            if(y == prev) continue;
            dfs(y, x);
            dp[x] += dp[y];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        R = Integer.parseInt(temp[1]);
        Q = Integer.parseInt(temp[2]);

        dp = new int[N + 1];
        con = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            con[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            con[x].add(y);
            con[y].add(x);
        }
        dfs(R, -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(dp[q]).append("\n");
        }
        System.out.println(sb);
    }
}
