package com.fastcampus.twopointers.두용액2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static int[] liquids;
    static int ans = 2000000001;
    static int[] answerLiquids = new int[2];

    static void twoPointers() {
        int L = 0; int R = liquids.length - 1;
        while(true) {
            if(ans > Math.abs(liquids[L] + liquids[R])) {
                answerLiquids[0] = liquids[L];
                answerLiquids[1] = liquids[R];
                ans = Math.abs(liquids[L] + liquids[R]);
            }
            if(liquids[L] + liquids[R] < 0) {
                L++;
            } else {
                R--;
            }

            if(L >= R) break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        liquids = new int[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(liquids);
        twoPointers();
        StringBuilder sb = new StringBuilder();
        for (Integer answerLiquid : answerLiquids) {
            sb.append(answerLiquid).append(" ");
        }

        System.out.println(sb.toString());
    }
}
