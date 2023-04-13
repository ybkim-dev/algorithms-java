package com.fastcampus2nd.tree.트리_1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int N;
  static ArrayList<Integer>[] child;
  static boolean[] visited;
  static int erasedNode;
  static int cnt;

  static void eraseNode(int target) {
    for (int i = 0; i < N; i++) {
      if(child[i].contains(target)) {
        child[i].remove(child[i].indexOf(target));
      }
    }
  }

  static void dfs(int curr) {
    visited[curr] = true;

    if(child[curr].size() == 0) cnt++;

    for (int next : child[curr]) {
      if(visited[next]) continue;
      dfs(next);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    child = new ArrayList[N];
    visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      child[i] = new ArrayList<>();
    }
    String[] temp = br.readLine().split(" ");
    int root = -1;
    for (int i = 0; i < N; i++) {
      if(Integer.parseInt(temp[i]) == -1) root = i;
      else child[Integer.parseInt(temp[i])].add(i);
    }

    erasedNode = Integer.parseInt(br.readLine());
    eraseNode(erasedNode);
    if(root != erasedNode) {
      dfs(root);
    }

    System.out.println(cnt);
  }

}
