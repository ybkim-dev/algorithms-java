package com.baekjoon.solved.벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static boolean[][][] visited;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist;
            int destroyCnt = p.destroyCnt;

            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[destroyCnt][nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    // 벽 아니면
                    // 공사 횟수 안늘리고 방문, 거리++
                    visited[destroyCnt][nx][ny] = true;
                    queue.add(new Point(nx, ny, dist + 1, destroyCnt));
                } else if(map[nx][ny] == 1 && destroyCnt == 0) {
                    // 벽인데 부순 횟수 없으면
                    // 부순 횟수 늘리고 방문, 거리++
                    visited[destroyCnt+1][nx][ny] = true;
                    queue.add(new Point(nx, ny, dist + 1, destroyCnt + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        map = new int[N][M];
        visited = new boolean[2][N][M];
        for(int i = 0; i < N; i++) {
            temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        System.out.println(bfs());

    }
}

class Point{
    int x;
    int y;
    int dist;
    int destroyCnt;

    public Point(int x, int y, int dist, int destroyCnt) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.destroyCnt = destroyCnt;
    }
}