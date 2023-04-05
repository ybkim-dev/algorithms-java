package com.fastcampus2nd.graphsearch.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int N, K;
  static int[] map;

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    map[start] = 0;

    while (!queue.isEmpty()) {
      int x = queue.poll();

      for (int k = 0; k < 3; k++) {
        int nx;
        if (k == 0) {
          nx = x - 1;
        } else if (k == 1) {
          nx = x + 1;
        } else {
          nx = x * 2;
        }

        if(nx < 0 || nx > 100000) continue;
        if(map[nx] > -1) continue;
        map[nx] = map[x] + 1;
        queue.add(nx);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");

    N = Integer.parseInt(temp[0]);
    K = Integer.parseInt(temp[1]);

    map = new int[100001];
    for (int i = 0; i <= 100000; i++) {
      map[i] = -1;
    }

    bfs(N);
    System.out.println(map[K]);
  }

}
