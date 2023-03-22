package com.fastcampus2nd.bruteforce.N과M1_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[] selected;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  static void solve(int index) {
    if(index == M + 1) {
      for (int i = 1; i <= M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
    } else {
      for (int i = 1; i <= N; i++) {
        if(!visited[i]) {
          visited[i] = true;
          selected[index] = i;
          solve(index + 1);
          selected[index] = 0;
          visited[i] = false;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");

    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);
    selected = new int[M + 1];
    visited = new boolean[N + 1];
    solve(1);
    System.out.println(sb);
  }

}
