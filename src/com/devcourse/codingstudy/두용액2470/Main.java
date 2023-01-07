package com.devcourse.codingstudy.두용액2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int ans = 2000000001;
    static int N;
    static int[] liquids;
    static int[] answers = new int[2];

    static void binarySearch() {
        int left = 0;
        int right = liquids.length - 1;
        while(left < right) {
            if(Math.abs(liquids[left] + liquids[right]) < ans) {
                answers[0] = liquids[left];
                answers[1] = liquids[right];
                ans = Math.abs(liquids[left] + liquids[right]);
            }

            if(liquids[left] + liquids[right] < 0) {
                left++;
            } else {
                right--;
            }
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
        binarySearch();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(answers[i]).append(" ");
        }
        System.out.println(sb);
    }
}
