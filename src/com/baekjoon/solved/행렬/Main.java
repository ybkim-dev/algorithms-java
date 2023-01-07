package com.baekjoon.solved.행렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] A;
    static int[][] B;
    static int N, M;

    static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }

    static void changeMatrix(Point point) {
        for (int i = point.x; i < point.x + 3; i++) {
            for (int j = point.y; j < point.y + 3; j++) {
                if(A[i][j] == 0) A[i][j] = 1;
                else A[i][j] = 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);



        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(temp[j]);
            }
        }

        if(N < 3 || M < 3) {
            if(isSame()) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }
        int cnt = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (A[i][j] != B[i][j]) {
                    changeMatrix(new Point(i, j));
                    cnt++;
                }
            }
        }

        if(isSame()) System.out.println(cnt);
        else System.out.println(-1);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
