package com.fastcampus.dynamicprogramming2.우수마을1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int[] people;
    static ArrayList<Integer>[] con;
    static int[][] dp;

    static void dfs(int x, int prev) {
        dp[x][0] = 0;
        dp[x][1] = people[x];

        for (int y : con[x]) {
            if(y == prev) continue;
            dfs(y, x);
            dp[x][0] += Math.max(dp[y][0], dp[y][1]);
            dp[x][1] += dp[y][0];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        people = new int[N + 1];
        con = new ArrayList[N + 1];
        String[] temp2 = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(temp2[i - 1]);
            con[i] = new ArrayList<>();
        }
        dp = new int[N + 1][2];

        for (int i = 1; i <= N - 1; i++) {
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            con[x].add(y);
            con[y].add(x);
        }

        dfs(1, -1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
}
