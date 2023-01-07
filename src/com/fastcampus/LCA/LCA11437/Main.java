package com.fastcampus.LCA.LCA11437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[][] dp; // dp[i][j] : j의 2^i승 만큼 조상의 번호
    static int[] depth;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dp = new int[17][N + 1];
        depth = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            String[] temp = br.readLine().split(" ");
            adj[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
            adj[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
        }

        // depth && dp 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        depth[1] = 0;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();

            for (int y : adj[x]) {
                if(visited[y]) continue;
                visited[y] = true;
                depth[y] = depth[x] + 1;
                dp[0][y] = x;
                queue.add(y);
            }
        }

        for (int i = 1; i <= 16; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][dp[i - 1][j]];
            }
        }

        // lca
        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            System.out.println(lca(a, b));
        }
    }

    static int lca(int a, int b) {
        // 무조건 b가 더 깊은 곳에 있게 바꾸기
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 높이 맞춰주기
        int gap = depth[b] - depth[a];

        for (int i = 0; i <= 16; i++) {
            if((gap & (1 << i)) > 0) {
                b = dp[i][b];
            }
        }

        if(a == b) return a;

        // a,b 높이가 같아졌으므로 공통 조상 찾기
        for(int i = 16; i >= 0; i--) {
            if(dp[i][a] != dp[i][b]) {
                a = dp[i][a];
                b = dp[i][b];
            }
        }

        return dp[0][a];
    }
}
