package com.fastcampus2nd.topologicalsort.줄세우기_2252;

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
  static Queue<Integer> queue = new LinkedList<>();
  static StringBuilder sb = new StringBuilder();

  static void topologicalSort() {
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      sb.append(curr).append(" ");
      for(int next : adj[curr]) {
        inDegree[next]--;
        if(inDegree[next] == 0) {
          queue.add(next);
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

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      int first = Integer.parseInt(temp[0]);
      int second = Integer.parseInt(temp[1]);
      adj[first].add(second);
      inDegree[second]++;
    }

    for (int i = 1; i <= N; i++) {
      if(inDegree[i] == 0) {
        queue.add(i);
      }
    }

    topologicalSort();
    System.out.println(sb);
  }

}
