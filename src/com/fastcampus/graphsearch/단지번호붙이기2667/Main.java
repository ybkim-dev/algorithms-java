package com.fastcampus.graphsearch.단지번호붙이기2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int findHouse(int startX, int startY) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        visited[startX][startY] = true;
        int houseCnt = 1;
        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                houseCnt++;
                queue.add(nx);
                queue.add(ny);
            }
        }
        return houseCnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int total = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && map[i][j] == 1) {
                    int houseCnt = findHouse(i, j);
                    total++;
                    result.add(houseCnt);
                }
            }
        }

        System.out.println(total);
        Collections.sort(result);
        for (int i = 0; i < total; i++) {
            System.out.println(result.get(i));
        }
    }
}
