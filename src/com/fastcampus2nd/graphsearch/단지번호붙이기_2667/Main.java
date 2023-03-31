package com.fastcampus2nd.graphsearch.단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static List<Integer> houses = new ArrayList<>();
  static int houseCount;

  static void bfs(int startX, int startY) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startX);
    queue.add(startY);
    visited[startX][startY] = true;
    int cnt = 0;
    while (!queue.isEmpty()) {
      int x = queue.poll();
      int y = queue.poll();
      cnt++;

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if(visited[nx][ny]) continue;
        if(map[nx][ny] == 1) {
          queue.add(nx);
          queue.add(ny);
          visited[nx][ny] = true;
        }
      }
    }

    houses.add(cnt);
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;
    houseCount++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];
      if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
      if(visited[nx][ny]) continue;
      if(map[nx][ny] == 1) {
        dfs(nx, ny);
      }
    }
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
    int totalCount = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && map[i][j] == 1) {
          dfs(i, j);
          houses.add(houseCount);
          houseCount= 0;
          totalCount++;
        }
      }
    }

    Collections.sort(houses);

    System.out.println(totalCount);
    houses.stream().forEach(System.out::println);

  }
}
