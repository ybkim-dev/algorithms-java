package com.fastcampus2nd.bruteforce.N과M4_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[] selected;
  static StringBuilder sb = new StringBuilder();

  static void solve(int index) {
    if(index == M + 1) {
      for (int i = 1; i <= M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
    } else {
      for (int i = selected[index-1]; i <= N; i++) {
        if(i == 0) continue;
        selected[index] = i;
        solve(index + 1);
        selected[index] = 0;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    selected = new int[M + 1];

    solve(1);
    System.out.println(sb);
  }

}
