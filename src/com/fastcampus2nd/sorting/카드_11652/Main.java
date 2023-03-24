package com.fastcampus2nd.sorting.카드_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static long[] nums;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    nums = new long[N];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Long.parseLong(br.readLine());
    }

    Arrays.sort(nums);
    long prevNum = nums[0];
    int cnt = 1;
    int max = 0;
    long maxNum = -1;
    for (int i = 1; i < N; i++) {
      if(prevNum == nums[i]) {
        cnt++;
      } else {
        if(max < cnt) {
          max = cnt;
          maxNum = prevNum;
        }
        prevNum = nums[i];
        cnt = 1;
      }
    }
    if(cnt > max) {
      max = cnt;
      maxNum = prevNum;
    }

    System.out.println(maxNum);
  }

}
