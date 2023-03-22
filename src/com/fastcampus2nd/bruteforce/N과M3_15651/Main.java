package com.fastcampus2nd.bruteforce.N과M3_15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N, M;
  static int[] selected;
  static StringBuilder sb = new StringBuilder();

  static void solve(int index) {
    if(index == M) {
      for (int i = 0; i < M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
    } else {
      for (int i = 1; i <= N; i++) {
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
    selected = new int[M];
    solve(0);
    System.out.println(sb);
  }
}
