package com.baekjoon.solved.교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int K;

    static boolean[][] visited;
    static int length;

    static int ans = -1;

    static void bfs() {
        visited = new boolean[1000001][K + 1];
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(N, 0));
        while (!queue.isEmpty()) {
            Info curr = queue.poll();

            if(curr.count == K) {
                ans = Math.max(curr.num, ans);
                continue;
            }

            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    int next = swap(curr.num, i, j);
                    if (next != -1 && visited[next][curr.count + 1] == false) {
                        visited[next][curr.count + 1] = true;
                        queue.add(new Info(next, curr.count + 1));
                    }
                }
            }

        }
    }

    static int swap(int n, int i, int j) {
        char[] numberArr = String.valueOf(n).toCharArray();

        if(i == 0 && numberArr[j] == '0') return -1;

        char tmp = numberArr[i];
        numberArr[i] = numberArr[j];
        numberArr[j] = tmp;
        return Integer.parseInt(new String(numberArr));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        length = temp[0].length();
        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        bfs();
        System.out.println(ans);
    }
}

class Info {
    int num;
    int count;

    public Info(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
