package com.fastcampus2nd.graphsearch.나이트의이동_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int T;
  static int N;
  static int[][] dist;
  static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
  static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};

  static void bfs(int startX, int startY, int endX, int endY) {
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

        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if(dist[nx][ny] > -1) continue;
        dist[nx][ny] = dist[x][y] + 1;
        queue.add(nx);
        queue.add(ny);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      N = Integer.parseInt(br.readLine());
      String[] temp = br.readLine().split(" ");
      int startX = Integer.parseInt(temp[0]);
      int startY = Integer.parseInt(temp[1]);

      temp = br.readLine().split(" ");
      int endX = Integer.parseInt(temp[0]);
      int endY = Integer.parseInt(temp[1]);

      dist = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          dist[i][j] = -1;
        }
      }

      bfs(startX, startY, endX, endY);
      System.out.println(dist[endX][endY]);
    }
  }

}
