package com.baekjoon.solved.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] A;

    static int binarySearch(int target) {
        int start = 0;
        int end = N-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) return mid;
            else if(A[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");

        for (int i = 0; i < temp.length; i++) {
            if (binarySearch(Integer.parseInt(temp[i])) != -1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
