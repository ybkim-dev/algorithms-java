package com.fastcampus2nd.topologicalsort.ACM크래프트_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int T;
  static int N, K;
  static int W;
  static int[] cost;
  static int[] max;   // max[i] : i로 향해 들어가는 노드들의 최대 cost
  static ArrayList<Integer>[] adj;
  static int[] inDegree;

  static void calculateMinTime() {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
        max[i] = cost[i];
      }
    }

    while (!queue.isEmpty()) {
      int curr = queue.poll();

      for(int next : adj[curr]) {
        if(max[next] < cost[curr]) {
          max[next] = cost[curr];
        }

        inDegree[next]--;
        if(inDegree[next] == 0) {
          cost[next] += max[next];
          queue.add(next);
        }
      }
    }
    System.out.println(cost[W]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String[] temp = br.readLine().split(" ");
      N = Integer.parseInt(temp[0]);
      K = Integer.parseInt(temp[1]);
      cost = new int[N + 1];
      max = new int[N + 1];
      inDegree = new int[N + 1];
      adj = new ArrayList[N + 1];
      for (int i = 1; i <= N; i++) {
        adj[i] = new ArrayList<>();
      }

      temp = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
        cost[i + 1] = Integer.parseInt(temp[i]);
      }

      for (int i = 0; i < K; i++) {
        temp = br.readLine().split(" ");
        int src = Integer.parseInt(temp[0]);
        int dest = Integer.parseInt(temp[1]);
        adj[src].add(dest);
        inDegree[dest]++;
      }

      W = Integer.parseInt(br.readLine());
      calculateMinTime();

    }
  }

}
