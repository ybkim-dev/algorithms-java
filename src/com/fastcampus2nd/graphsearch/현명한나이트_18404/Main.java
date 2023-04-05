package com.fastcampus2nd.graphsearch.현명한나이트_18404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int N, M;
  static int[][] map;
  static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
  static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int[][] dist;

  static void bfs(int startX, int startY) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startX);
    queue.add(startY);
    dist[startX][startY] = 0;

    while (!queue.isEmpty()) {
      int x = queue.poll();
      int y = queue.poll();

      for (int k = 0; k < 8; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if(nx <= 0 || nx > N || ny <= 0 || ny > N) continue;
        if(dist[nx][ny] > -1) continue;
        dist[nx][ny] = dist[x][y] + 1;
        queue.add(nx);
        queue.add(ny);
      }

    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);
    map = new int[N + 1][N + 1];
    dist = new int[N + 1][N + 1];

    temp = br.readLine().split(" ");
    int startX = Integer.parseInt(temp[0]);
    int startY = Integer.parseInt(temp[1]);

    for (int i = 1; i <= N; i++) {
      Arrays.fill(dist[i], -1);
    }

    bfs(startX, startY);

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      int targetX = Integer.parseInt(temp[0]);
      int targetY = Integer.parseInt(temp[1]);

      System.out.println(dist[targetX][targetY]);
    }


  }

}
