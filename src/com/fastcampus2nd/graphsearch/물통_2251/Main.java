package com.fastcampus2nd.graphsearch.물통_2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {

  static boolean[][][] visited;
  static State limit;

  static Set<Integer> set = new HashSet<>();

  static void bfs(State start) {
    Queue<State> queue = new LinkedList<>();
    queue.add(start);
    visited[start.X[0]][start.X[1]][start.X[2]] = true;
    set.add(start.X[2]);

    while (!queue.isEmpty()) {
      State curr = queue.poll();
      for (int from = 0; from < 3; from++) {
        for (int to = 0; to < 3; to++) {
          if(from == to) continue;
          State adj = curr.move(from, to, limit.X);
          if(visited[adj.X[0]][adj.X[1]][adj.X[2]]) continue;
          if(adj.X[0] == 0) {
            set.add(adj.X[2]);
          }
          queue.add(adj);
          visited[adj.X[0]][adj.X[1]][adj.X[2]] = true;
        }
      }

    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    limit = new State(new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
        Integer.parseInt(temp[2])});

    visited = new boolean[201][201][201];
    bfs(new State(new int[]{0, 0, limit.X[2]}));
    List<Integer> arr = new ArrayList<>();
    for (Integer x : set) {
      arr.add(x);
    }
    Collections.sort(arr);
    StringBuilder sb = new StringBuilder();
    for(Integer x: arr) {
      sb.append(x).append(" ");
    }
    sb.append("\n");
    System.out.println(sb);
  }

  static class State {
    int[] X;

    public State(int[] _X) {
      X = new int[3];
      for (int i = 0; i < 3; i++) {
        X[i] = _X[i];
      }
    }

    public State move(int from, int to, int[] limit) {
      int[] nX = new int[] {X[0], X[1], X[2]};
      if(nX[from] + nX[to] <= limit[to]) {
        nX[to] += nX[from];
        nX[from] = 0;
      } else {
        nX[from] = nX[from] + nX[to] - limit[to];
        nX[to] = limit[to];
      }
      return new State(nX);
    }
  }

}
