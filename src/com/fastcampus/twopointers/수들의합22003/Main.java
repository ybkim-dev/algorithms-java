package com.fastcampus.twopointers.수들의합22003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[] A;
    static int cnt;

    static void twoPointer() {
        int R = 0; int sum = 0;
        for (int L = 1; L <= N; L++) {
            // L을 한 칸 당김.
            sum -= A[L - 1];
            // 합이 M 미만일 동안 R 증가.
            while (R + 1 <= N && sum < M) {
                R++;
                sum += A[R];
            }

            if(sum == M) cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        A = new int[N + 1];
        temp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(temp[i - 1]);
        }

        twoPointer();
        System.out.println(cnt);

    }
}
