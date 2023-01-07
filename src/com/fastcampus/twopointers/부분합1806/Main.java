package com.fastcampus.twopointers.부분합1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int S;

    static int[] arr;
    static int ans;

    static void twoPointers() {
        int R = 0; int sum = 0; ans = N + 1;
        for (int L = 1; L <= N; L++) {
            sum -= arr[L - 1];
            while(R + 1 <= N && sum < S) {
                R++;
                sum += arr[R];
            }
            if(sum >= S) {
                ans = Math.min(ans, R - L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        S = Integer.parseInt(temp[1]);

        arr = new int[N+1];
        temp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(temp[i-1]);
        }

        twoPointers();
        System.out.println(ans);
    }
}
