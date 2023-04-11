package com.fastcampus2nd.graphsearch.탈출_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int R, C;
  static char[][] map;
  static int[][] dist;
  static boolean[][] visitedWater;
  static boolean[][] visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static Queue<Element> queue = new LinkedList<>();

  static void simulate(int waterX, int waterY, int sX, int sY, int targetX, int targetY) {
    queue.add(new Element(0, sX, sY));
    visited[sX][sY] = true;

    while (!queue.isEmpty()) {
      Element curr = queue.poll();

      if (curr.x == targetX && curr.y == targetY) {
        break;
      }

      if (curr.type == 0) {
        // 고슴도치
        for (int k = 0; k < 4; k++) {
          int nx = curr.x + dx[k];
          int ny = curr.y + dy[k];
          if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
            continue;
          }
          if (visited[nx][ny]) {
            continue;
          }
          if (map[nx][ny] == '*' || map[nx][ny] == 'X') {
            continue;
          }
          dist[nx][ny] = dist[curr.x][curr.y] + 1;
          visited[nx][ny] = true;
          map[nx][ny] = 'S';
          queue.add(new Element(0, nx, ny));
        }


      } else {
        // 물
        for (int k = 0; k < 4; k++) {
          int nx = curr.x + dx[k];
          int ny = curr.y + dy[k];
          if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
            continue;
          }
          if (visitedWater[nx][ny]) {
            continue;
          }
          if (map[nx][ny] == 'D' || map[nx][ny] == 'X') {
            continue;
          }
          map[nx][ny] = '*';
          visitedWater[nx][ny] = true;
          queue.add(new Element(1, nx, ny));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    R = Integer.parseInt(temp[0]);
    C = Integer.parseInt(temp[1]);

    map = new char[R][C];
    dist = new int[R][C];
    visited = new boolean[R][C];
    visitedWater = new boolean[R][C];

    int waterX = 0;
    int waterY = 0;
    int sX = 0;
    int sY = 0;
    int targetX = 0;
    int targetY = 0;

    for (int i = 0; i < R; i++) {
      temp = br.readLine().split("");
      for (int j = 0; j < C; j++) {
        map[i][j] = temp[j].charAt(0);
        if (map[i][j] == 'S') {
          sX = i;
          sY = j;
        }
        if (map[i][j] == 'D') {
          targetX = i;
          targetY = j;
        }
        if (map[i][j] == '*') {
          waterX = i;
          waterY = j;
          queue.add(new Element(1, waterX, waterY));
          visitedWater[waterX][waterY] = true;
        }
      }
    }
    dist[targetX][targetY] = -1;
    simulate(waterX, waterY, sX, sY, targetX, targetY);

    System.out.println(dist[targetX][targetY] == -1 ? "KAKTUS" : dist[targetX][targetY]);
  }

  static class Element {

    int type; // 0 은 고슴도치, 1은 물
    int x;
    int y;

    public Element(int type, int x, int y) {
      this.type = type;
      this.x = x;
      this.y = y;
    }
  }
}
