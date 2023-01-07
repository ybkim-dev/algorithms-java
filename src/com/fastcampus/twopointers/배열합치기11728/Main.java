package com.fastcampus.twopointers.배열합치기11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[] A;
    static int[] B;

    static void twoPointers() {
        StringBuilder sb = new StringBuilder();
        int aIndex = 0; int bIndex = 0;
        while(true) {
            if(A[aIndex] < B[bIndex]) {
                sb.append(A[aIndex]).append(" ");
                aIndex++;
            } else {
                sb.append(B[bIndex]).append(" ");
                bIndex++;
            }

            if (aIndex == N) {
                while (bIndex < M) {
                    sb.append(B[bIndex]).append(" ");
                    bIndex++;
                }
            } else if(bIndex == M) {
                while(aIndex < N) {
                    sb.append(A[aIndex]).append(" ");
                    aIndex++;
                }
            }

            if(aIndex == N && bIndex == M) break;
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        A = new int[N];
        B = new int[M];

        temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(temp[i]);
        }

        temp = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(temp[i]);
        }

        twoPointers();
    }

}
