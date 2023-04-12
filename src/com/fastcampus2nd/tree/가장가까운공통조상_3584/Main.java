package com.fastcampus2nd.tree.가장가까운공통조상_3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int T;
  static int N;
  static boolean[] visited;
  static ArrayList<Integer>[] adj;
  static StringBuilder sb = new StringBuilder();

  static void dfsA(int start) {
    visited[start] = true;

    for(int next : adj[start]) {
      dfsA(next);
    }
  }

  static void dfsB(int start) {
    if(visited[start]) {
      sb.append(start);
      return;
    }

    for(int next : adj[start]) {
      dfsB(next);
    }
  }



  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    while(T-- > 0) {
      N = Integer.parseInt(br.readLine());
      adj = new ArrayList[N + 1];
      visited = new boolean[N + 1];
      for (int i = 1; i <= N; i++) {
        adj[i] = new ArrayList<>();
      }

      for (int i = 0; i < N - 1; i++) {
        String[] temp = br.readLine().split(" ");
        int parent = Integer.parseInt(temp[0]);
        int child = Integer.parseInt(temp[1]);
        adj[child].add(parent);
      }

      String[] temp = br.readLine().split(" ");
      int A = Integer.parseInt(temp[0]);
      int B = Integer.parseInt(temp[1]);

      dfsA(A);
      dfsB(B);
      sb.append("\n");
    }

    System.out.println(sb);
  }

}
