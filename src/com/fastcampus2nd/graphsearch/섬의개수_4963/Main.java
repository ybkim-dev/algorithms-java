package com.fastcampus2nd.graphsearch.섬의개수_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int w, h;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
  static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

  static void bfs(int startX, int startY) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startX);
    queue.add(startY);
    visited[startX][startY] = true;

    while (!queue.isEmpty()) {
      int x = queue.poll();
      int y = queue.poll();

      for (int k = 0; k < 8; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
        if(visited[nx][ny]) continue;
        if(map[nx][ny] == 0) continue;

        queue.add(nx);
        queue.add(ny);
        visited[nx][ny] = true;
      }
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
      String[] temp = br.readLine().split(" ");
      w = Integer.parseInt(temp[0]);
      h = Integer.parseInt(temp[1]);
      if(w == 0 &&  h == 0) break;

      map = new int[h][w];
      visited = new boolean[h][w];

      for (int i = 0; i < h; i++) {
        temp = br.readLine().split(" ");
        for (int j = 0; j < w; j++) {
          map[i][j] = Integer.parseInt(temp[j]);
        }
      }
      int cnt=  0;
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if(!visited[i][j] && map[i][j] == 1) {
            bfs(i, j);
            cnt++;
          }
        }
      }

      System.out.println(cnt);
    }
  }

}
