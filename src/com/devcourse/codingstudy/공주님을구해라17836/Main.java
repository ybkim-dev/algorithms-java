package com.devcourse.codingstudy.공주님을구해라17836;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M, T;
    static int[][] map;
    static boolean[][] visited;
    static int[][] lengthMap;
    static int lengthWithSword = 10001;

    static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if(map[nx][ny] == 2) {
                    lengthMap[nx][ny] = lengthMap[x][y] + 1;
                    visited[nx][ny] = true;
                    lengthWithSword = Math.min((lengthMap[nx][ny] + (M-1 - ny + N-1 - nx)), lengthWithSword);
                } else if(map[nx][ny] == 1) continue;
                else {
                    lengthMap[nx][ny] = lengthMap[x][y] + 1;
                    queue.add(nx);
                    queue.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        T = Integer.parseInt(temp[2]);
        map = new int[N][M];
        lengthMap = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        bfs(0, 0);
        if(lengthMap[N-1][M-1] == 0 && lengthWithSword == 10001) System.out.println("Fail");
        else if(lengthMap[N-1][M-1] != 0 && lengthWithSword == 10001) {
            if(lengthMap[N-1][M-1] > T) System.out.println("Fail");
            else System.out.println(lengthMap[N-1][M-1]);
        }
        else if(lengthMap[N-1][M-1] == 0 && lengthWithSword != 10001) {
            if(lengthWithSword > T) System.out.println("Fail");
            else System.out.println(lengthWithSword);
        }
        else {
            int ans = Math.min(lengthMap[N - 1][M - 1], lengthWithSword);
            if(ans > T) System.out.println("Fail");
            else System.out.println(ans);
        }
    }
}
