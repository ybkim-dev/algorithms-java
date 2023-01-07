package com.baekjoon.solved.스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int[][] S;
    static int[] selected;
    static ArrayList<Integer> unselected;
    static boolean[] visited;

    static int startTeam;
    static int linkTeam;
    static int min = (int)1e9;

    static void dfs(int index) {
        if(index == N / 2 + 1) {
            for(int i = 1; i <= N; i++) {
                boolean isInSelected = false;
                for(int j = 1; j < selected.length; j++) {
                    if(i == selected[j]) isInSelected = true;
                }
                if(!isInSelected) {
                    unselected.add(i);
                }
            }
            // 나머지에 대해서 계산하기
            for (int i = 1; i <= N / 2; i++) {
                for (int j = i + 1; j <= N / 2; j++) {
                    startTeam += (S[selected[i]][selected[j]] + S[selected[j]][selected[i]]);
                    linkTeam += (S[unselected.get(i)][unselected.get(j)] + S[unselected.get(j)][unselected.get(i)]);
                }
            }

            min = Math.min(min, Math.abs(startTeam - linkTeam));
            startTeam = 0;
            linkTeam = 0;
            unselected.clear();
            unselected.add(0);
        }
        else {
            for(int i = selected[index - 1] + 1; i <= N; i++) {
                if(visited[i] == true) continue;
                visited[i] = true;
                selected[index] = i;
                dfs(index + 1);
                selected[index]  =0;
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        selected = new int[N / 2 + 1];
        unselected = new ArrayList<>();
        unselected.add(0);
        visited = new boolean[N + 1];
        S = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        dfs(1);
        System.out.println(min);
    }
}
