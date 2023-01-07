package com.fastcampus2nd.binarysearch.먹을것인가먹힐것인가7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T;
    static int[] A;
    static int[] B;
    static int aCnt;
    static int bCnt;

    static int binarySearch(int target) {
        int left = 0;
        int right = B.length - 1;
        int result = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(B[mid] < target) {
                result = mid + 1;
                left = mid + 1;
            } else if(B[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] temp = br.readLine().split(" ");
            aCnt = Integer.parseInt(temp[0]);
            bCnt = Integer.parseInt(temp[1]);
            A = new int[aCnt];
            B = new int[bCnt];

            temp = br.readLine().split(" ");
            for (int i = 0; i < aCnt; i++) {
                A[i] = Integer.parseInt(temp[i]);
            }
            temp = br.readLine().split(" ");
            for (int i = 0; i < bCnt; i++) {
                B[i] = Integer.parseInt(temp[i]);
            }

            Arrays.sort(B);
            int ans = 0;
            for (int i = 0; i < aCnt; i++) {
                int result = binarySearch(A[i]);
                if(result != -1) ans += result;
            }

            System.out.println(ans);
        }

    }
}
