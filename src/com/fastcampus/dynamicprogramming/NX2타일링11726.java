package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NX2타일링11726 {
    static int[] DP;
    static int n;
    static void dynamicProgramming() {
        DP[1] = 1; DP[2] = 2;
        for(int i = 3; i <= n; i++) {
            DP[i] = (DP[i-1] + DP[i-2]) % 10007;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        DP = new int[1001];
        dynamicProgramming();
        System.out.println(DP[n]);
    }
}
