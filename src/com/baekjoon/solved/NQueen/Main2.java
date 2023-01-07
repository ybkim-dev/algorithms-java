package com.baekjoon.solved.NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int[] y;
    static int N;

    static boolean isAttackable(int x1, int y1, int x2, int y2) {
        if (y1 == y2) return true; // 같은 col
        if (x1 + y1 == x2 + y2) return true; // 같은 우상향 대각선
        if (x1 - y1 == x2 - y2) return true; // 같은 우하향 대각선
        return false;
    }
    static int answer;
    static void dfs(int x) {
        if(x == N+1) {
            answer++;
        } else {
            for(int i = 1; i <= N; i++) {
                boolean attackable = false;
                for(int j = 1; j <= x - 1; j++) {
                    // 이전 선택된 값들 보면서 공격 여부 파악
                    if(isAttackable(x, i, j, y[j])) {
                        attackable = true;
                        break;
                    }
                }
                if(!attackable) {
                    y[x] = i;
                    dfs(x+1);
                    y[x] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        y = new int[N + 1];

        dfs(1);

        System.out.println(answer);
    }
}
