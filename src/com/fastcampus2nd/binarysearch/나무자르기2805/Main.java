package com.fastcampus2nd.binarysearch.나무자르기2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] trees;

    static boolean isValid(int height) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if(trees[i] > height) {
                sum += trees[i] - height;
            }
        }
        if(sum >= M) return true;
        return false;
    }

    static int binarySearch() {
        int left = 0; int right = (int)1e9;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(isValid(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        trees = new int[N];
        temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(temp[i]);
        }
        int ans = binarySearch();
        System.out.println(ans);
    }
}
