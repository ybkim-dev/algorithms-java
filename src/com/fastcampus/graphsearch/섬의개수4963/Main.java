package com.fastcampus.graphsearch.섬의개수4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int w, h;

    static int[][] map;
    static boolean[][] visited;

    static int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};

    static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(startX);
        queue.add(startY);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (map[nx][ny] == 1 && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] temp = br.readLine().split(" ");

            w = Integer.parseInt(temp[0]);
            h = Integer.parseInt(temp[1]);

            if(w == h && w == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                temp = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
            int islandCnt = 0;
            // bfs
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && visited[i][j] == false) {
                        islandCnt++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(islandCnt);
        }



    }
}
