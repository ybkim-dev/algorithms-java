package com.fastcampus2nd.sorting.카드11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] nums;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(nums);
        long prevNum = nums[0];
        int cnt = 1;
        int maxCnt = 0;
        long ans = prevNum;
        for (int i = 1; i < N; i++) {
            if(prevNum == nums[i]) {
                cnt++;
            } else {
                if(cnt > maxCnt) {
                    ans = prevNum;
                    maxCnt = cnt;
                }
                cnt = 1;
            }
            prevNum = nums[i];
        }
        if(cnt > maxCnt) {
            ans = prevNum;
            maxCnt = cnt;
        }
        System.out.println(ans);
    }
}
