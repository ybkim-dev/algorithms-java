package com.fastcampus.twopointers.좋다1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] A;
    static int cnt;

    static void twoPointers(int targetIndex, int target) {
        int L = 0; int R = A.length -1;

        if(L == targetIndex) L++;
        if(R == targetIndex) R--;

        while(L < R) {
            if(A[L] + A[R] < target) {
                L++;
                if(L == targetIndex) L++;
            } else if(A[L] + A[R] == target) {
                cnt++;
                break;
            } else {
                R--;
                if(R == targetIndex) R--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            twoPointers(i, A[i]);
        }

        System.out.println(cnt);

    }
}
