package com.fastcampus2nd.bruteforce.NQueen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, cnt;
  static boolean[][] map;

  static boolean ableToSetQueen(int row, int col) {
    for(int i = row - 1; i >= 0; i--) if(map[i][col]) return false;
    for(int i = 1; i <= row; i++) {
      if(col + i >= N) break;
      if(map[row-i][col+i]) return false;
    }
    for(int i = 1; i <= row; i++) {
      if(col - i < 0) break;
      if(map[row-i][col - i]) return false;
    }
    return true;
  }

  static void solve(int row) {
    if(row == N) {
      cnt++;
    } else {
      for (int col = 0; col < N; col++) {
        if(ableToSetQueen(row, col)) {
          map[row][col] = true;
          solve(row+1);
          map[row][col] = false;
        }
      }
    }
  }



  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new boolean[N][N];

    solve(0);

    System.out.println(cnt);
  }

}
