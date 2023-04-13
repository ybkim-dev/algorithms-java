package com.fastcampus2nd.tree.회사문화1_14267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int n, m;
  static ArrayList<Integer>[] child;
  static int[] dp; // dp[x] : x의 칭찬값

  static void dfs(int curr) {
    for(int next : child[curr]) {
      dp[next] += dp[curr];
      dfs(next);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");

    n = Integer.parseInt(temp[0]);
    m = Integer.parseInt(temp[1]);

    dp = new int[n + 1];
    child = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      child[i] = new ArrayList<>();
    }

    temp = br.readLine().split(" ");
    int root = -1;
    for (int i = 1; i <= n; i++) {
      int element = Integer.parseInt(temp[i - 1]);
      if(element == -1) {
        root = i;
      } else {
        child[element].add(i);
      }
    }

    for (int i = 0; i < m; i++) {
      temp = br.readLine().split(" ");
      int element = Integer.parseInt(temp[0]);
      int weight = Integer.parseInt(temp[1]);
      dp[element] += weight;
    }

    dfs(root);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(dp[i]).append(" ");
    }
    System.out.println(sb);
  }

}
