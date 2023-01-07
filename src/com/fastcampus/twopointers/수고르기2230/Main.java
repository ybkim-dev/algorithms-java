package com.fastcampus.twopointers.수고르기2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static int[] A;
    static int MAX_VALUE = 2000000001;
    static int difference = MAX_VALUE;
    static void twoPointers() {
        int R = 0;
        for (int L = 1; L <= N; L++) {
            // L 이동
            // 차이가 M보다 작을 동안 R 증가
            while(R+1 <= N && A[R] - A[L] < M) {
                R++;
            }
            if(A[R] - A[L] >= M) {
                difference = Math.min(difference, A[R] - A[L]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
        twoPointers();
        System.out.println(difference);
    }
}
