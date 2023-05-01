package com.fastcampus2nd.backtracking.알파벳_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  static int N, M;
  static char[][] alphabet;
  static boolean[][] visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int ans;

  static void dfs(int x, int y, Set<Character> sets) {
    visited[x][y] = true;
    if(sets.size() > ans) {
      ans = sets.size();
    }

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];
      if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
      if(visited[nx][ny]) continue;
      if(sets.contains(alphabet[nx][ny])) continue;
      sets.add(alphabet[nx][ny]);
      dfs(nx, ny, sets);
      sets.remove(alphabet[nx][ny]);
      visited[nx][ny] = false;
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    alphabet = new char[N][M];

    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    alphabet = new char[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      temp = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        alphabet[i][j] = temp[j].charAt(0);
      }
    }
    HashSet<Character> sets = new HashSet<>();
    sets.add(alphabet[0][0]);
    dfs(0, 0, sets);
    System.out.println(ans);
  }
}
