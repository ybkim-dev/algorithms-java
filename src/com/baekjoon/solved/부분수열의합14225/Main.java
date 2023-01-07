package com.baekjoon.solved.부분수열의합14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] S;
    static int N;
    static boolean[] existence;

    static void sumElements(int result, int index) {
        existence[result] = true;
        for(int i = index + 1; i <= N; i++) {
            sumElements(S[i] + result, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N + 1];
        String[] temp = br.readLine().split(" ");
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(temp[i - 1]);
            sum += S[i];
        }

        existence = new boolean[sum + 2];

        for(int i = 1; i <= N; i++) {
            sumElements(S[i], i);
        }

        for(int i= 1; i <= sum+1; i++) {
            if(existence[i] == false) {
                System.out.println(i);
                break;
            }
        }

    }
}
