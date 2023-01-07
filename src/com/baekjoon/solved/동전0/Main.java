package com.baekjoon.solved.동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int idx = coins.length - 1;
        int count = 0;
        while(K > 0) {
            count += (K / coins[idx]);
            K -= coins[idx] * (K / coins[idx]);
            idx -= 1;
        }
        System.out.println(count);
    }
}
