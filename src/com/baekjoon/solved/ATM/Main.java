package com.baekjoon.solved.ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        P = new int[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(P);

        int[] DP = new int[N + 1];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            DP[i] = DP[i - 1] + P[i-1];
            answer += DP[i];
        }

        System.out.println(answer);
    }
}
