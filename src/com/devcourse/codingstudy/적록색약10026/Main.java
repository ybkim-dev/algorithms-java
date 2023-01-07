package com.devcourse.codingstudy.적록색약10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;

    static void bfsNormal(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            // 1. 1개 꺼내기
            Integer x = queue.poll();
            Integer y = queue.poll();
            // 2. 도착지인가?
            // 3. 순회
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                // 4. 갈 수 있는가?
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != map[x][y]) continue;
                // 5. 간다
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    static void bfsGR(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            // 1. 1개 꺼내기
            Integer x = queue.poll();
            Integer y = queue.poll();
            // 2. 도착지인가?
            // 3. 순회
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                // 4. 갈 수 있는가?
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(map[x][y] == 'G' || map[x][y] == 'R') {
                    if(map[nx][ny] == 'B') continue;
                } else {
                    // map[x][y] == 'B' 라면
                    if(map[nx][ny] != map[x][y]) continue;
                }
                // 5. 간다
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j].charAt(0);
            }
        }


        int normalAns = 0;
        int GRAns = 0;
        // normal 먼저
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfsNormal(i, j);
                    normalAns++;
                }
            }
        }

        // GR
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfsGR(i, j);
                    GRAns++;
                }
            }
        }

        System.out.println(normalAns + " " + GRAns);
    }
}
