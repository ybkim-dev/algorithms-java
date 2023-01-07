package com.baekjoon.solved.거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        N = 1000 - N;
        int[] money = new int[]{500, 100, 50, 10, 5, 1};
        int ans = 0;
        int idx = 0;
        while(N > 0) {
            if(N < money[idx]) {
                idx++;
                continue;
            }
            ans += (N / money[idx]);
            N %= money[idx];
            idx++;
        }

        System.out.println(ans);
    }
}
