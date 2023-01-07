package com.fastcampus.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 플로이드와샬 {
    static int n, m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n,m;
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) map[i][j] = 0;
                else map[i][j] = (int)1e9;
            }
        }

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            map[Integer.parseInt(temp[0])-1][Integer.parseInt(temp[1])-1] = Integer.parseInt(temp[2]);
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == (int)1e9) {
                    System.out.println("INF");
                } else {
                    System.out.println(map[i][j]);
                }
            }
        }
    }
}
