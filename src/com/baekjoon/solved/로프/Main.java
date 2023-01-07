package com.baekjoon.solved.로프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int ans = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if(ans < (arr.length - 1 - i + 1) * arr[i]) {
                ans = (arr.length - 1 - i + 1) * arr[i];
            }
        }
        System.out.println(ans);
    }
}
