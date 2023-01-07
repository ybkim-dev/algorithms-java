package com.baekjoon.solved.전구과스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] switchesOne;
    static int[] switchesTwo;
    static int[] targets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        switchesOne = new int[N + 2];
        switchesTwo = new int[N + 2];
        targets = new int[N + 2];
        String[] temp = br.readLine().split("");
        for(int i = 1; i <=N; i++) {
            switchesOne[i] = Integer.parseInt(temp[i - 1]);
            switchesTwo[i] = Integer.parseInt(temp[i - 1]);
        }
        temp = br.readLine().split("");
        for (int i = 1; i <= N; i++) {
            targets[i] = Integer.parseInt(temp[i - 1]);
        }
        int cnt1 = 0;
        int cnt2 = 1;
        // 1을 건드린 경우
        switchesTwo[1] = 1 - switchesOne[1];
        switchesTwo[2] = 1 - switchesTwo[2];


        for(int i = 2; i <= N; i++) {
            // 1번을 건드리지 않은 경우
            if (switchesOne[i - 1] != targets[i - 1]) {
                switchesOne[i - 1] = 1 - switchesOne[i - 1];
                switchesOne[i] = 1 - switchesOne[i];
                if(i != N) {
                    switchesOne[i + 1] = 1 - switchesOne[i + 1];
                }
                cnt1++;
            }
            // 1번을 건드린 경우
            if (switchesTwo[i - 1] != targets[i - 1]) {
                switchesTwo[i - 1] = 1 - switchesTwo[i - 1];
                switchesTwo[i] = 1 - switchesTwo[i];
                if(i != N) {
                    switchesTwo[i + 1] = 1 - switchesTwo[i + 1];
                }
                cnt2++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if(switchesOne[i] != targets[i]) cnt1 = Integer.MAX_VALUE;
            if(switchesTwo[i] != targets[i]) cnt2 = Integer.MAX_VALUE;
        }

        if (cnt1 == Integer.MAX_VALUE && cnt2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(cnt1, cnt2));
        }
    }
}
