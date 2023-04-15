package com.fastcampus2nd.dynamicprogramming.우수마을_1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int N;
  static int[][] dp;
  static ArrayList<Integer>[] adj;
  static int[] cost;

  static void dfs(int curr, int prev) {
    dp[curr][0] = 0;
    dp[curr][1] = cost[curr];

    for (int next : adj[curr]) {
      if(next == prev) continue;
      dfs(next, curr);
      dp[curr][0] += Math.max(dp[next][0], dp[next][1]);
      dp[curr][1] += dp[next][0];
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    cost = new int[N + 1];
    dp = new int[N+1][2];
    adj = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }

    String[] temp = br.readLine().split(" ");

    for (int i = 1; i <= N; i++) {
      cost[i] = Integer.parseInt(temp[i - 1]);
    }

    for (int i = 1; i < N; i++) {
      temp = br.readLine().split(" ");
      int src = Integer.parseInt(temp[0]);
      int dest = Integer.parseInt(temp[1]);
      adj[src].add(dest);
      adj[dest].add(src);
    }

    dfs(1, -1);
    System.out.println(Math.max(dp[1][0], dp[1][1]));
  }

}
