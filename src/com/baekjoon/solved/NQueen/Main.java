package com.baekjoon.solved.NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    static int[] line;

    static int ans;

    static boolean isAttackable(int x, int y, int r, int c) {
        if(y == c) return true;
        if(x+y == r+c) return true;
        if(x - y == r - c) return true;
        return false;
    }

    static void dfs(int index) {
        if (index == N) {
            ans++;
            return;
        } else {
            for (int i = 0; i < N; i++) {
                boolean attackable = false;
                for (int j = 0; j < index; j++) {
                    if (isAttackable(index, i, j, line[j])) {
                        attackable = true;
                        break;
                    }
                }
                if(attackable == false) {
                    line[index] = i;
                    dfs(index + 1);
                    line[index] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        line = new int[N];
        dfs(0);
        System.out.println(ans);
    }
}
