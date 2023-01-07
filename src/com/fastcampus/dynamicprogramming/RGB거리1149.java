package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB거리1149 {
    static int N;
    static int[][] DP;
    static int[][] color;

    static void dynamicProgramming() {
        DP[1][1] = color[1][1];
        DP[1][2] = color[1][2];
        DP[1][3] = color[1][3];
        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= 3; j++) {
                if(j == 1) {
                    DP[i][j] = Math.min(DP[i-1][2], DP[i-1][3]) + color[i][j];
                } else if(j==2) {
                    DP[i][j] = Math.min(DP[i-1][1], DP[i-1][3]) + color[i][j];
                } else {
                    DP[i][j] = Math.min(DP[i-1][1], DP[i-1][2]) + color[i][j];
                }
            }
        }
        System.out.println(Math.min(Math.min(DP[N][1], DP[N][2]), DP[N][3]));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][4];
        color = new int[N+1][4];
        for(int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split(" ");
            for(int j = 1; j<= 3; j++) {
                color[i][j] = Integer.parseInt(temp[j-1]);
            }
        }
        dynamicProgramming();
    }
}
