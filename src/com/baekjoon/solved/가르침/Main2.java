package com.baekjoon.solved.가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int N, K;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static String[] words;

    static int getReadableCnt() {
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            boolean readable = true;
            for(int j = 0; j < words[i].length(); j++) {
                if(visited[words[i].charAt(j) - 'a'] == false) {
                    readable = false;
                    break;
                }
            }
            if(readable) count++;
        }
        return count;
    }

    static void dfs(char index, int k) {
        if(k == K) {
            max = Math.max(max, getReadableCnt());
        } else {
            for(char c = index; c <= 'z'; c++) {
                if(visited[c-'a'] == false) {
                    visited[c-'a'] = true;
                    dfs(++index, k+1);
                    visited[c-'a'] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);
        words = new String[N];
        visited = new boolean[26];
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[antic]", "");
        }

        if(K < 5) {
            System.out.println(0);
        } else {
            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

            for(char i = 'b'; i<= 'z'; i++) {
                dfs(i, 5);
            }
            System.out.println(max);
        }
    }
}
