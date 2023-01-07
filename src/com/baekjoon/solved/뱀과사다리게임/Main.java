package com.baekjoon.solved.뱀과사다리게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[] map;
    static int[] connection;
    static boolean[] visited;

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(current == 100) break;

            for(int i = 1; i <= 6; i++){
                int next = current + i;
                if(next > 100) continue;
                if(visited[next]) continue;
                if(connection[next] != 0) {
                    next = connection[next];
                }
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    map[next] = map[current] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        map = new int[101];
        connection = new int[101];
        visited = new boolean[101];

        for(int i = 0; i < N + M; i++) {
            temp = br.readLine().split(" ");
            connection[Integer.parseInt(temp[0])] = Integer.parseInt(temp[1]);
        }


        bfs();
        System.out.println(map[100]);
    }
}
