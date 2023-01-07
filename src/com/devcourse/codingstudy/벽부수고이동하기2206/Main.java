package com.devcourse.codingstudy.벽부수고이동하기2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;   // visited[x][y][0] -> 벽 안부수고 방문, visited[x][y][1] -> 벽 부수고 방문

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = -1;

    static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][0] = true;
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if(curr.x == N-1 && curr.y == M-1) {
                ans = curr.dist;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][curr.crashed]) continue;
                if(map[nx][ny] == 0) {
                    // 벽이 아니면 정상 로직
                    visited[nx][ny][curr.crashed] = true;
                    queue.add(new Point(nx, ny, curr.dist + 1, curr.crashed));
                } else if(map[nx][ny] == 1 && curr.crashed == 0) {
                    // 벽인데 한번도 깬적 없으면
                    visited[nx][ny][curr.crashed + 1] = true;
                    queue.add(new Point(nx, ny, curr.dist + 1, curr.crashed + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        map = new int[N][M];    // 지도
        visited = new boolean[N][M][2];

        // 지도 채우기
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        bfs(new Point(0, 0, 1, 0));
        System.out.println(ans);
    }

    static class Point {
        int x;
        int y;
        int dist;
        int crashed;

        public Point(int x, int y, int dist, int crashed) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.crashed = crashed;
        }
    }
}
