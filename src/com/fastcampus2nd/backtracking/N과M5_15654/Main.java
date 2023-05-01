package com.fastcampus2nd.backtracking.N과M5_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N, M;
  static int[] nums;
  static int[] selected;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  static void dfs(int index) {
    if(index == M) {
      for (int i = 0; i < M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
    } else {
      for (int i = 0; i < N; i++) {
        if(visited[nums[i]]) continue;
        selected[index] = nums[i];
        visited[nums[i]] = true;
        dfs(index + 1);
        visited[nums[i]] = false;
        selected[index] = 0;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    nums = new int[N];
    selected = new int[M];
    visited = new boolean[10001];
    temp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(temp[i]);
    }

    Arrays.sort(nums);
    dfs(0);
    System.out.println(sb);
  }

}
