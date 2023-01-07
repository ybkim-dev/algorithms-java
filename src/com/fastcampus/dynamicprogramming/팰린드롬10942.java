package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬10942 {
    static boolean[][] DP;
    static int[] num;
    static int N, M;

    static void dynamicProgramming() {
        // initialize.
        for(int i = 1; i<= N; i++) {
            DP[i][i] = true;
            if(i+1 <= N) {
                DP[i][i+1] = true;
            }

        }

        for(int len = 1; len <= N-1; len++) {
            for(int i = 1; i <= N-len; i++) {
                int j = i + len;
                if(DP[i+1][j-1]==true && num[i]== num[j]) DP[i][j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        DP = new boolean[N+1][N+1];
        String[] temp = br.readLine().split(" ");
        for(int i = 1; i <=N; i++) {
            num[i] = Integer.parseInt(temp[i-1]);
        }
        dynamicProgramming();
        M = Integer.parseInt(br.readLine());
        for(int i = 1; i <= M; i++ ){
            temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            sb.append(DP[start][end]? 1 : 0).append("\n");
        }
        System.out.println(sb.toString());
    }
}
