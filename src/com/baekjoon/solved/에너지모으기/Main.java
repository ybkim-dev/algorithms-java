package com.baekjoon.solved.에너지모으기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static ArrayList<Integer> W;

    static int max = -1;

    static void dfs(ArrayList<Integer> arr, int index, int result) {
        if(index == N - 2) {
            max = Math.max(max, result);
        } else {
            for(int i = 1; i < arr.size() - 1; i++) {
                int multipleResult =(arr.get(i - 1) * arr.get(i + 1));
                result += multipleResult;
                int pop = arr.get(i);
                arr.remove(i);
                dfs(arr, index + 1, result);
                arr.add(i, pop);
                result -= multipleResult;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        W = new ArrayList<>();
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            W.add(Integer.parseInt(temp[i]));
        }

        dfs(W, 0, 0);
        System.out.println(max);

    }
}
