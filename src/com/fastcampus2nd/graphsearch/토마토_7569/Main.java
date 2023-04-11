package com.fastcampus2nd.graphsearch.토마토_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int[][][] tomatoes;
  static int N, M, H;
  static int[] dx = {1, 0, -1, 0, 0, 0};
  static int[] dy = {0, 1, 0, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static boolean[][][] visited;
  static int[][][] times;
  static int ans;
  static Queue<Point> queue = new LinkedList<>();

  static void bfs() {

    while (!queue.isEmpty()) {
      Point curr = queue.poll();

      for (int k = 0; k < 6; k++) {
        int nx = curr.x + dx[k];
        int ny = curr.y + dy[k];
        int nz = curr.z + dz[k];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
        if(visited[nz][nx][ny]) continue;
        if(tomatoes[nz][nx][ny] == -1) continue;
        times[nz][nx][ny] = times[curr.z][curr.x][curr.y] + 1;
        visited[nz][nx][ny] = true;
        ans = times[nz][nx][ny];
        tomatoes[nz][nx][ny] = 1;
        queue.add(new Point(nx, ny, nz));
      }
    }
  }

  static class Point{
    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");

    M = Integer.parseInt(temp[0]);
    N = Integer.parseInt(temp[1]);
    H = Integer.parseInt(temp[2]);

    tomatoes = new int[H][N][M];
    visited = new boolean[H][N][M];
    times = new int[H][N][M];

    for (int k = 0; k < H; k++) {
      for (int i = 0; i < N; i++) {
        temp = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
          tomatoes[k][i][j] = Integer.parseInt(temp[j]);
          if(tomatoes[k][i][j] == 1) {
            queue.add(new Point(i, j, k));
            visited[k][i][j] = true;
          }
        }
      }
    }

    bfs();

    if(check()) {
      System.out.println(ans);
    } else {
      System.out.println(-1);
    }


  }

  public static boolean check() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k < H; k++) {
          if(tomatoes[k][i][j] == 0) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
