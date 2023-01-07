package com.baekjoon.solved.돌그룹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[][] visited;
    static class Stone {
        int a;
        int b;
        int c;

        public Stone(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static boolean bfs(int a, int b, int c) {
        if ((a + b + c) % 3 != 0) {
            return false;
        }

        Queue<Stone> queue = new LinkedList<>();
        queue.add(new Stone(a, b, c));
        visited[a][b] = true;

        while(!queue.isEmpty()) {
            Stone stone = queue.poll();

            a = stone.a;
            b = stone.b;
            c = stone.c;

            if (a == b && b == c) {
                return true;
            }

            if(a != b) {
                int na = a > b ? a - b : a * 2;
                int nb = a > b ? b * 2 : b - a;

                if(!visited[na][nb]) {
                    queue.add(new Stone(na, nb, c));
                    visited[na][nb] = true;
                }
            }

            if(a != c) {
                int na = a > c ? a - c : a * 2;
                int nc = a > c ? c * 2 : c - a;

                if(!visited[na][nc]) {
                    queue.add(new Stone(na, b, nc));
                    visited[na][nc] = true;
                }
            }

            if(b != c) {
                int nb = b > c ? b - c : b * 2;
                int nc = b > c ? c * 2 : c - b;

                if(!visited[nb][nc]) {
                    queue.add(new Stone(a, nb, nc));
                    visited[nb][nc] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int A = Integer.parseInt(temp[0]);
        int B = Integer.parseInt(temp[1]);
        int C = Integer.parseInt(temp[2]);

        visited = new boolean[1501][1501];

        System.out.println(bfs(A, B, C) ? 1 : 0);
    }
}
