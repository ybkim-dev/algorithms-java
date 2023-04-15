package com.fastcampus2nd.topologicalsort.영우는사기꾼_14676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int N, M, K;
  static ArrayList<Integer>[] adj;
  static int[] inDegree;
  static int[] cnt; // 건물 수
  static int[] satisfy; // 현재 만족하는 상태
  static Queue<Integer> queue = new LinkedList<>();
  static boolean lie;

  static void topologySort() {
    while (!queue.isEmpty()) {
      int type = queue.poll();
      int node = queue.poll();
      if(type == 1) {
        // 건설
        // 기존 건물 다 안지었으면 에러
        if(satisfy[node] < inDegree[node]) {
          lie = true;
          return;
        }

        cnt[node]++;
        if(cnt[node] == 1) {
          // 처음으로 지은 건물이라면
          for(int next : adj[node]) {
            satisfy[next]++;
          }
        }
      } else {
        // 파괴
        // 건설한 적 없으면 파괴시 에러
        if(cnt[node] == 0) {
          lie = true;
          return;
        }

        cnt[node]--;
        if(cnt[node] == 0) {
          // 파괴되어서 다음 건물들을 지을 수 없다면
          for(int next : adj[node]) {
            satisfy[next]--;
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);
    K = Integer.parseInt(temp[2]);

    adj = new ArrayList[N + 1];
    inDegree = new int[N + 1];
    cnt = new int[N + 1];
    satisfy = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      int src = Integer.parseInt(temp[0]);
      int dest = Integer.parseInt(temp[1]);
      adj[src].add(dest);
      inDegree[dest]++;
    }

    for (int i = 0; i < K; i++) {
      temp = br.readLine().split(" ");
      queue.add(Integer.parseInt(temp[0]));
      queue.add(Integer.parseInt(temp[1]));
    }

    topologySort();
    if (lie) {
      System.out.println("Lier!");
    } else {
      System.out.println("King-God-Emperor");
    }
  }

}
