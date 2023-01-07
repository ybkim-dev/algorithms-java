package com.baekjoon.solved.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int max = -1;

    static void bfs(int startX, int startY) {
        visited = new boolean[N][M];
        Queue<Integer> queue = new LinkedList<>();

        visited[startX][startY] = true;
        queue.add(startX);
        queue.add(startY);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1 || map[nx][ny] == 2) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                map[nx][ny] = 9;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    static void makeWall(int index) {
        if(index == 4) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 2) bfs(i, j);
                }
            }
            int cleanAreas = 0;
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0) cleanAreas++;
                }
            }
            max = Math.max(max, cleanAreas);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 9) map[i][j] = 0;
                }
            }
        } else {
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0) {
                        map[i][j] = 1;
                        makeWall(index + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        makeWall(1);
        System.out.println(max);
    }
}
