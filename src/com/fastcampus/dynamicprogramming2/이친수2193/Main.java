package com.fastcampus.dynamicprogramming2.이친수2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DP = new long[N + 1][2];

        DP[1][0] = 0;
        DP[1][1] = 1;

        if(N >= 2) {
            for (int i = 2; i <= N; i++) {
                DP[i][0] = DP[i - 1][0] + DP[i - 1][1];
                DP[i][1] = DP[i - 1][0];
            }
        }

        System.out.println(DP[N][0] + DP[N][1]);
    }
}
