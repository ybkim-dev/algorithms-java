package com.baekjoon.solved.데스나이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static int[][] chess;
    static boolean[][] visited;

    static int startX;
    static int startY;
    static int targetX;
    static int targetY;
    static int min = 40001;

    static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(startX);
        queue.add(startY);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            if(x == targetX && y == targetY) {
                // 목적지
                min = Math.min(min, chess[targetX][targetY]);
                return;
            }

            for (int k = 0; k < 6; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                chess[nx][ny] = chess[x][y] + 1;
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        startX = Integer.parseInt(temp[0]);
        startY = Integer.parseInt(temp[1]);
        targetX = Integer.parseInt(temp[2]);
        targetY = Integer.parseInt(temp[3]);

        chess = new int[N][N];
        visited = new boolean[N][N];
        bfs(startX, startY);
        if(min == 40001) System.out.println(-1);
        else System.out.println(min);
    }
}
