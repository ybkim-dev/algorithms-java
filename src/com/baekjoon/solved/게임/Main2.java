package com.baekjoon.solved.게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class Main2 {
    static int N,M;
    static int[][] dp; // dp[i][j] --> i행 j열에서의 최대 이동 수
    static int[][] map;
    static int hole = 99;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int ans;
    static boolean loopFlag = false;
    static void dfs(int x, int y, int cnt) {
        if(cnt > ans) ans = cnt;
        dp[x][y] = cnt;
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k] * map[x][y];
            int ny = y + dy[k] * map[x][y];
            // 범위 밖으로 벗어나는가? || 구멍인가
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 99) continue;
            // 이미 방문했는가?
            if(visited[nx][ny] == true) {
                loopFlag = true;
                return;
            }
            // 방문할 곳의 값이 이미 더 크면 방문하지 않기
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

        dp = new int[N][M];
        dp[0][0] = 1;

        map = new int[N][M];

        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            temp = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                if(temp[j].charAt(0) == 'H') {
                    map[i][j] = hole;
                }else {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
        }
        visited[0][0] = true;
        dfs(0, 0, 1);

        if(loopFlag == true) System.out.println(-1);
        else {
            System.out.println(ans);
        }
    }
}
