package com.fastcampus.graphsearch.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = -1;

    static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx <= 0 || nx > N || ny <= 0 || ny > M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 1 || map[nx][ny] == 2) continue;
                visited[nx][ny] = true;
                map[nx][ny] = 9;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    static void dfs(int index) {
        if (index == 3) {
            // bfs
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(map[i][j] == 2 && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            // clean area 세기
            int cleanArea = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(map[i][j] == 0) cleanArea++;
                }
            }

            ans = Math.max(ans, cleanArea);

            // 원상 복구
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(map[i][j] == 9) map[i][j] = 0;
                }
            }

            visited = new boolean[N + 1][M + 1];


        } else {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(map[i][j] == 0) {
                        map[i][j] = 1;
                        dfs(index + 1);
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

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        dfs(0);
        System.out.println(ans);
    }

}
