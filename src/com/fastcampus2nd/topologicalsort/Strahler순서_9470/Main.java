package com.fastcampus2nd.topologicalsort.Strahler순서_9470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int T;
  static int K, M, P;
  static int[] inDegree;
  static int[] max;
  static int[] maxCount;
  static int[] strahler;
  static ArrayList<Integer>[] adj;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String[] temp = br.readLine().split(" ");
      K = Integer.parseInt(temp[0]);
      M = Integer.parseInt(temp[1]);
      P = Integer.parseInt(temp[2]);
      inDegree = new int[M + 1];
      max = new int[M + 1];
      maxCount = new int[M + 1];
      strahler = new int[M + 1];
      adj = new ArrayList[M + 1];
      for (int i = 1; i <= M; i++) {
        adj[i] = new ArrayList<>();
      }

      for (int i = 0; i < P; i++) {
        temp = br.readLine().split(" ");
        int src = Integer.parseInt(temp[0]);
        int dest = Integer.parseInt(temp[1]);
        adj[src].add(dest);
        inDegree[dest]++;
      }

      // topological Sort
      Queue<Integer> queue = new LinkedList<>();
      for (int i = 1; i <= M; i++) {
        if(inDegree[i] == 0) {
          strahler[i] = 1;
          queue.add(i);
        }
      }

      while (!queue.isEmpty()) {
        int curr = queue.poll();

        for(int next : adj[curr]) {
          if(max[next] < strahler[curr]) {
            max[next] = strahler[curr];
            maxCount[next] = 1;
          } else if(max[next] == strahler[curr]) {
            max[next] = strahler[curr];
            maxCount[next]++;
          }
          inDegree[next]--;

          if(inDegree[next]==0){
            if(maxCount[next] <= 1) {
              strahler[next] = max[next];
            } else {
              strahler[next] = max[next] + 1;
            }
            queue.add(next);
          }
        }
      }
      int ans = 0;
      for (int i = 1; i <= M; i++) {
        if (ans < strahler[i]) {
          ans = strahler[i];
        }
      }

      sb.append(K).append(" ").append(ans).append("\n");
    }
    System.out.println(sb);
  }

}
