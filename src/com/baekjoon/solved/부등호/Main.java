package com.baekjoon.solved.부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long min = 9876543211L;
    static String minString;
    static long max = -1;
    static String maxString;

    static int K;
    static char[] symbols;
    static int[] selected;
    static boolean[] visited;

    static void dfs(int index) {
        if (index == K + 1) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i <= K; i++) {
                sb.append(selected[i]);
            }
            if(min > Long.parseLong(sb.toString())) {
                min = Long.parseLong(sb.toString());
                minString = sb.toString();
            }
            if (max < Long.parseLong(sb.toString())) {
                max = Long.parseLong(sb.toString());
                maxString = sb.toString();
            }
        } else {
            if(symbols[index] == '<') {
                for (int i = selected[index - 1] + 1; i <= 9; i++) {
                    if (visited[i]) continue;
                    selected[index] = i;
                    visited[i] = true;
                    dfs(index + 1);
                    visited[i] = false;
                    selected[index] = 0;
                }
            } else if(symbols[index] == '>') {
                for (int i = selected[index - 1] - 1; i >= 0; i--) {
                    if (visited[i]) continue;
                    selected[index] = i;
                    visited[i] = true;
                    dfs(index + 1);
                    visited[i] = false;
                    selected[index] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        symbols = new char[K + 1];
        String[] temp = br.readLine().split(" ");
        for(int i = 1; i <= K; i++) {
            symbols[i] = temp[i - 1].charAt(0);
        }

        selected = new int[K + 1];
        visited = new boolean[10];

        Arrays.fill(selected, -1);

        for(int i = 0; i <= 9; i++) {
            selected[0] = i;
            visited[i] = true;
            dfs(1);
            visited[i] = false;
            selected[0] = -1;
        }

        System.out.println(maxString);
        System.out.println(minString);
    }
}
