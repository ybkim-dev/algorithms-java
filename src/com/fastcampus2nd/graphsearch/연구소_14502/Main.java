package com.fastcampus2nd.graphsearch.연구소_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int N, M;
  static int[][] map;
  static int[][] tempMap;
  static boolean[][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int maxCnt;

  static void bfs(int startX, int startY) {
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

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if(visited[nx][ny]) continue;
        if(tempMap[nx][ny] == 1) continue;
        tempMap[nx][ny] = 2;
        queue.add(nx);
        queue.add(ny);
        visited[nx][ny] = true;
      }
    }
  }

  static void growVirus() {
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        tempMap[i][j] = map[i][j];
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if(map[i][j] == 2) {
          bfs(i,j);
        }
      }
    }

    int cnt =0 ;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if(tempMap[i][j] == 0) {
          cnt++;
        }
      }
    }

    if (cnt > maxCnt) {
      maxCnt = cnt;
    }
  }

  static void makeWall(int index) {
    if(index == 3) {
      growVirus();
    } else {
      for (int i = 0; i < N; i++) {
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
    tempMap = new int[N][M];

    for (int i = 0; i < N; i++) {
      temp = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(temp[j]);
      }
    }

    makeWall(0);
    System.out.println(maxCnt);
  }

}
