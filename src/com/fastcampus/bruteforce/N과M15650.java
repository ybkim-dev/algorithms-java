package com.fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M15650 {
    static int[] selected;
    static boolean[] isUsed;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static void recFunc(int k) {
        if(k == M+1) {
            for(int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
            sb.append("\n");
        } else {
            for(int i = 1; i <= N; i++) {
                if(selected[k-1] <= i) {
                    if(isUsed[i]==false) {
                        selected[k] = i;
                        isUsed[i] = true;
                        recFunc(k+1);
                        isUsed[i] = false;
                        selected[k] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        selected = new int[M+1];
        isUsed = new boolean[N+1];
        recFunc(1);
        System.out.println(sb.toString());
    }
}
