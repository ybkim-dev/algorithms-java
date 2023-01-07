package com.devcourse.codingstudy.랜선자르기1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int K,N;
    static int[] lines;

    static long countPieces(long operand) {
        long count = 0;
        for (int i = 0; i < K; i++) {
            count += (lines[i] / operand);
        }
        return count;
    }

    static long upperBound(long left, long right) {
        while(left <= right) {
            long mid = (left + right) / 2;
            if(countPieces(mid) < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        K = Integer.parseInt(temp[0]);
        N = Integer.parseInt(temp[1]);

        lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);
        long ans = upperBound(1L, Integer.MAX_VALUE);
        System.out.println(ans);

    }
}
