package com.fastcampus.graphsearch.유기농배추1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int T;
    static int M, N;
    static int K;

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    static boolean[][] visited;
    static int[][] map;
    static int wormCount;

    static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(startX);
        queue.add(startY);

        while (!queue.isEmpty()) {
            // 1. queue에서 꺼내기
            int x = queue.poll();
            int y = queue.poll();
            // 2. 목적지인가?

            // 3. 인접한 노드 순회
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                // 4. 갈 수 있는가?
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny] == true) continue;
                if(map[nx][ny] == 0) continue;
                // 5. 체크 인
                visited[nx][ny] = true;
                // 6. 큐에 넣기
                queue.add(nx);
                queue.add(ny);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        T = Integer.parseInt(temp[0]);
        for (int t = 0; t < T; t++) {
            temp = br.readLine().split(" ");
            M = Integer.parseInt(temp[0]);
            N = Integer.parseInt(temp[1]);
            K = Integer.parseInt(temp[2]);

            visited = new boolean[N][M];
            map = new int[N][M];

            for (int i = 0; i < K; i++) {
                temp = br.readLine().split(" ");
                map[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = 1;
            }

            wormCount = 0;
            // bfs
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && visited[i][j] == false) {
                        bfs(i, j);
                        wormCount++;
                    }
                }
            }
            System.out.println(wormCount);
        }
    }
}
