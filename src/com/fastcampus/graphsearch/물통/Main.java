package com.fastcampus.graphsearch.물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][][] visited;
    static boolean[] possible;
    static int[] limit;
    static void bfs(int x1, int x2, int x3) {
        Queue<State> queue = new LinkedList<>();

        visited[x1][x2][x3] = true;
        queue.add(new State(new int[]{x1, x2, x3}));

        while (!queue.isEmpty()) {
            State curr = queue.poll();
            if(curr.X[0] == 0) possible[curr.X[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if(from == to) continue;
                    State next = curr.move(from, to, limit);

                    if(!visited[next.X[0]][next.X[1]][next.X[2]]) {
                        visited[next.X[0]][next.X[1]][next.X[2]] = true;
                        queue.add(next);
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        limit = new int[3];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(temp[i]);
        }

        visited = new boolean[201][201][201];
        possible = new boolean[201];

        bfs(0, 0, limit[2]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= limit[2]; i++) {
            if(possible[i]) sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}

class State {
    int[] X;

    State(int[] _X) {
        X = new int[3];
        for (int i = 0; i < 3; i++) X[i] = _X[i];
    }

    State move(int from, int to, int[] limit) {
        int[] nX = new int[]{X[0], X[1], X[2]};

        if (X[from] + X[to] >= limit[to]) {
            nX[from] -= limit[to] - X[to];
            nX[to] = limit[to];
        } else {
            nX[to] += X[from];
            nX[from] = 0;
        }
        return new State(nX);
    }
}