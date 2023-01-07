package com.baekjoon.solved.게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int ans;
    static boolean isLooped;

    static void dfs(int x, int y, int cnt) {
        if(cnt > ans) ans = cnt;
        dp[x][y] = cnt;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k] * map[x][y];
            int ny = y + dy[k] * map[x][y];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 99) continue;
            if(visited[nx][ny]) {
                isLooped = true;
                return;
            }
            if(dp[nx][ny] > cnt) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, cnt + 1);
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        map = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (temp[j].equals("H")) {
                    map[i][j] = 99;
                } else {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
        }

        dfs(0, 0, 1);
        if(isLooped) System.out.println(-1);
        else System.out.println(ans);

    }
}
