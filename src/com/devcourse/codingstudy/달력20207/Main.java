package com.devcourse.codingstudy.달력20207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] cnt;
    static int sum = 0;
    static int heightMax = 0;
    static int width = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = new int[367];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            for(int j = start; j <= end; j++) {
                cnt[j]++;
            }
        }

        for (int i = 1; i <= 366; i++) {
            if(cnt[i] ==0) {
                sum += heightMax * width;
                heightMax = 0;
                width = 0;
                continue;
            }
            width++;
            heightMax = Math.max(heightMax, cnt[i]);
        }

        System.out.println(sum);
    }

}
