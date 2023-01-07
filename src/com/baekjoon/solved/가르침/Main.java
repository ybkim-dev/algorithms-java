package com.baekjoon.solved.가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, K;
    static boolean[] visited;
    static String[] words;
    static int ans = -1;

    static int getReadable() {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            boolean readable = true;
            for (int j = 0; j < words[i].length(); j++) {
                if(visited[words[i].charAt(j) - 'a'] == false) {
                    readable = false;
                    break;
                }
            }
            if(readable) {
                count++;
            }
        }
        return count;
    }

    static void dfs(char charIndex,int index) {
        if(index == K) {
            ans = Math.max(ans, getReadable());
        } else {
            for (char c = charIndex; c <= 'z'; c++) {
                if (!visited[c - 'a']) {
                    visited[c-'a'] = true;
                    dfs(c, index + 1);
                    visited[c - 'a'] =false;
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

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word;
        }


        if(K < 5) {
            System.out.println(0);
        } else {
            visited = new boolean[26];

            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

            for (char c = 'b'; c <= 'z'; c++) {
                dfs(c, 5);
            }

            System.out.println(ans);
        }



    }
}
