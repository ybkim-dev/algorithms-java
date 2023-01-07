package com.fastcampus.twopointers.ListOfUniqueNumbers13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static long ans;
    static int[] arr;
    static int[] count;

    static void twoPointers() {
        int R = 0;
        for (int L = 1; L <= N; L++) {
            // L 이동
            count[arr[L-1]] = 0;
            // R 이동
            while(R + 1 <= N && count[arr[R+1]] == 0) {
                R++;
                count[arr[R]] = 1;
            }

            ans += (R - L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        count = new int[N + 1];
        String[] temp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(temp[i - 1]);
        }

        twoPointers();

        System.out.println(ans);
    }



}
