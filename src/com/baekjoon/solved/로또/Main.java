package com.baekjoon.solved.로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int K;
    static int[] S;
    static int[] selected;
    static StringBuilder sb;
    static void dfs(int index) {
        if (index == 7) {
            for (int i = 1; i <= 6; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= S.length - 1; i++) {
                if (selected[index - 1] >= S[i]) continue;
                selected[index] = S[i];
                dfs(index + 1);
                selected[index] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            sb = new StringBuilder();
            String[] temp = br.readLine().split(" ");
            if(temp.length == 1 && temp[0].equals("0")) break;
            K = Integer.parseInt(temp[0]);
            S = new int[K + 1];
            selected = new int[7];
            for(int i = 1; i <= temp.length - 1; i++) {
                S[i] = Integer.parseInt(temp[i]);
            }
            dfs(1);
            System.out.println(sb.toString());

        }



    }
}
