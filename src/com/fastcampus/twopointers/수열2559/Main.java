package com.fastcampus.twopointers.수열2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int K;
    static int[] temperatures;
    static int ans = -10000000;
    static void twoPointer() {
        int R = 0; int sum = 0;
        for (int L = 1; L <= N - K + 1; L++) {
            // L 날짜 이동
            sum -= temperatures[L - 1];
            // R - L + 1 이 K가 될 때까지 R 이동
            while(R + 1 <= N && R - L + 1 < K) {
                R++;
                sum += temperatures[R];
            }
            ans = Math.max(ans, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        temperatures = new int[N + 1];
        temp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            temperatures[i] = Integer.parseInt(temp[i - 1]);
        }

        twoPointer();
        System.out.println(ans);
    }
}
