package com.fastcampus2nd.binarysearch.수찾기1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int[] A;
    static int[] B;

    public static boolean binarySearch(int[] A, int L, int R, int target) {
        boolean result = false;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] < target) {
                L = mid + 1;
            } else if(A[mid] > target) {
                R = mid - 1;
            } else {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        String[] temp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(temp[i - 1]);
        }
        M = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(temp[i - 1]);
        }

        Arrays.sort(A, 1, A.length);
        for (int i = 1; i <= M; i++) {
            boolean result = binarySearch(A, 1, N, B[i]);
            if(result) System.out.println(1);
            else System.out.println(0);
        }
    }
}
