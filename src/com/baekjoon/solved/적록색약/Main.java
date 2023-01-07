package com.baekjoon.solved.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static boolean[][] visited;
    static char[][] map;
    static char[][] disorderMap;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void count(int _x, int _y) {
        Queue<Integer> queue = new LinkedList<>();
        visited[_x][_y] = true;
        queue.add(_x);
        queue.add(_y);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == map[x][y]) {
                    visited[nx][ny] = true;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
    }

    static void disorderCount(int _x, int _y) {
        Queue<Integer> queue = new LinkedList<>();
        visited[_x][_y] = true;
        queue.add(_x);
        queue.add(_y);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(disorderMap[nx][ny] == disorderMap[x][y]) {
                    visited[nx][ny] = true;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        disorderMap = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j].charAt(0);
                if (temp[j].charAt(0) == 'G') {
                    disorderMap[i][j] = 'R';
                } else {
                    disorderMap[i][j] = map[i][j];
                }
            }
        }

        int normalCnt = 0;
        int disorderCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j] == false) {
                    count(i, j);
                    normalCnt++;
                }
            }
        }

        for(int i = 0;i<N;i++){
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j] == false) {
                    disorderCount(i, j);
                    disorderCnt++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(normalCnt).append(" ").append(disorderCnt);
        System.out.println(sb.toString());
    }
}
