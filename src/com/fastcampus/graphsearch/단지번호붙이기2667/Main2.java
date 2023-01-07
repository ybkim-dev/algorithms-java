package com.fastcampus.graphsearch.단지번호붙이기2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] map;

    static boolean[][] visited;

    static List<Integer> countList;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        countList = new ArrayList<>();
        N = Integer.parseInt(temp[0]);
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int cnt = 0;
        // bfs
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && visited[i][j] == false) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(countList);
        for (int i : countList) {
            System.out.println(i);
        }
    }

    static StringBuilder sb = new StringBuilder();

    static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        int nodeCount = 0;
        visited[startX][startY] = true;
        queue.add(startX);
        queue.add(startY);

        while (!queue.isEmpty()) {
            // 1. queue 에서 꺼내기
            int x = queue.poll();
            int y = queue.poll();
            // 2. 목적지인가? -> 정답 처리하기
            nodeCount++;
            // 3. 인접 노드 순회
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                // 4. 갈 수 있는가?
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny] == true) continue;
                // 5. 체크인
                if(map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    // 6. 큐에 추가
                    queue.add(nx);
                    queue.add(ny);
                }

            }

        }
        countList.add(nodeCount);
    }
}
