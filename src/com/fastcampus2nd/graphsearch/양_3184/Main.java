package com.fastcampus2nd.graphsearch.양_3184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int R, C;
  static char[][] yard;
  static boolean[][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int wolfTotalCount, sheepTotalCount;

  static void bfs(int startX, int startY) {
    int sheepCount = 0;
    int wolfCount = 0;

    Queue<Integer> queue = new LinkedList<>();

    if(yard[startX][startY] == 'v') wolfCount++;
    if(yard[startX][startY] == 'o') sheepCount++;
    queue.add(startX);
    queue.add(startY);
    visited[startX][startY] = true;

    while (!queue.isEmpty()) {
      int x = queue.poll();
      int y = queue.poll();

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
        if(visited[nx][ny]) continue;
        if(yard[nx][ny] == '#') continue;
        if(yard[nx][ny] == '.' || yard[nx][ny] == 'o' || yard[nx][ny] == 'v') {
          if(yard[nx][ny] == 'v') wolfCount++;
          if(yard[nx][ny] == 'o') sheepCount++;
          queue.add(nx);
          queue.add(ny);
          visited[nx][ny] = true;
        }
      }
    }

    if(wolfCount >= sheepCount) {
      wolfTotalCount += wolfCount;
    } else {
      sheepTotalCount += sheepCount;
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    R = Integer.parseInt(temp[0]);
    C = Integer.parseInt(temp[1]);

    yard = new char[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      String temp2 = br.readLine();
      for (int j = 0; j < C; j++) {
        yard[i][j] = temp2.charAt(j);
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if(!visited[i][j] && yard[i][j] != '#') {
          bfs(i, j);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(sheepTotalCount).append(" ").append(wolfTotalCount);
    System.out.println(sb);
  }

}
