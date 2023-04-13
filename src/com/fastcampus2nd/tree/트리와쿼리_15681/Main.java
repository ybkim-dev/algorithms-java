package com.fastcampus2nd.tree.트리와쿼리_15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static int N, R, Q;
  static ArrayList<Integer>[] adj;
  static int[] dp;  // dp[x] : x를 root로 하는 subtree의 정점의 개수

  static void dfs(int curr, int prev) {
    dp[curr] = 1;
    for (int next : adj[curr]) {
      if(next == prev) continue;
      dfs(next, curr);
      dp[curr] += dp[next];
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    R = Integer.parseInt(temp[1]);
    Q = Integer.parseInt(temp[2]);

    adj = new ArrayList[N + 1];
    dp = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      temp = br.readLine().split(" ");
      int src = Integer.parseInt(temp[0]);
      int dest = Integer.parseInt(temp[1]);
      adj[src].add(dest);
      adj[dest].add(src);
    }

    dfs(R, 0);

    for (int i = 0; i < Q; i++) {
      int query = Integer.parseInt(br.readLine());
      System.out.println(dp[query]);
    }
  }

}
