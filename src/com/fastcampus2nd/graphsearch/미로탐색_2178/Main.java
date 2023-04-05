package com.fastcampus2nd.graphsearch.미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int N, M;
  static int[][] map;
  static boolean[][] visited;
  static int[][] dist;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  static void findShortestPath(int startX, int startY) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startX);
    queue.add(startY);
    dist[startX][startY] = 1;

    while (!queue.isEmpty()) {
      int x = queue.poll();
      int y = queue.poll();

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if(visited[nx][ny])continue;
        if(map[nx][ny] ==0) continue;
        queue.add(nx);
        queue.add(ny);
        visited[nx][ny] = true;
        dist[nx][ny] = dist[x][y] + 1;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");

    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);
    map = new int[N][M];
    visited = new boolean[N][M];
    dist = new int[N][M];

    for (int i = 0; i < N; i++) {
      temp = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(temp[j]);
      }
    }

    findShortestPath(0, 0);
    System.out.println(dist[N - 1][M - 1]);
  }

}
