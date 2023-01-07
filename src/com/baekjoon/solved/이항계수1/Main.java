package com.baekjoon.solved.이항계수1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        if(K == 0) System.out.println(1);
        else {
            int divided = 1;
            for(int i = N; i > N - K; i--) {
                divided *= i;
            }
            int divider = 1;
            for(int i = K; i >= 1; i--) {
                divider *= i;
            }

            System.out.println(divided / divider);
        }
    }
}
