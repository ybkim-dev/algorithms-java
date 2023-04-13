package com.fastcampus2nd.topologicalsort.음악프로그램_2623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int N, M;
  static ArrayList<Integer>[] adj;
  static int[] inDegree;
  static StringBuilder sb = new StringBuilder();
  static boolean[] visited;

  static void topologicalSort() {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if(inDegree[i] == 0) {
        queue.add(i);
        visited[i] = true;
      }
    }

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      sb.append(curr).append("\n");

      for (int next : adj[curr]) {
        inDegree[next]--;
        if (inDegree[next] == 0) {
          queue.add(next);
          visited[next] = true;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    adj = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }
    inDegree = new int[N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      for (int j = 2; j < temp.length; j++) {
        inDegree[Integer.parseInt(temp[j])]++;
        adj[Integer.parseInt(temp[j - 1])].add(Integer.parseInt(temp[j]));
      }
    }

    topologicalSort();
    int visitCount = 0;
    for (int i = 1; i <= N; i++) {
      if(visited[i]) visitCount++;
    }
    if(visitCount == N) {
      System.out.println(sb);
    } else{
      System.out.println(0);
    }

  }

}
