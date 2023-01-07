package com.fastcampus.twopointers.귀여운라이언15565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int K;
    static int[] dolls;

    static int twoPointers() {
        int R = 0; int cnt = 0; int length = N + 1;
        for (int L = 1; L <= N; L++) {
            // L 이동
            if(dolls[L-1] == 1) cnt -= 1;
            // cnt == K 까지 R 증가
            while(R +1 <= N && cnt < K) {
                R++;
                if(dolls[R] == 1) {
                    cnt++;
                    if(cnt == K) {
                        break;
                    }
                }
            }
            if(cnt >= K) {
                length = Math.min(length, R - L + 1);
            }

        }
        if(length == N+1) length = -1;
        return length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        dolls = new int[N + 1];
        temp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            dolls[i] = Integer.parseInt(temp[i - 1]);
        }

        System.out.println(twoPointers());
    }
}
