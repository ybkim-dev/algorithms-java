package com.baekjoon.solved.주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] weight = new long[N - 1];
        long[] oil = new long[N];
        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < N - 1; i++) {
            weight[i] = Long.parseLong(temp[i]);
        }

        temp = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            oil[i] = Long.parseLong(temp[i]);
        }

        for (int i = 1; i < N; i++) {
            if(oil[i-1] < oil[i]) {
                oil[i] = oil[i - 1];
            }
        }

        long ans = 0;
        for (int i = 0; i < N-1; i++) {
            ans += (oil[i] * weight[i]);
        }
        System.out.println(ans);
    }
}
