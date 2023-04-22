package com.fastcampus2nd.math.서로소평균_21920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] nums;
  static int X;

  static int gcd(int x, int y) {
    if(y == 0) return x;
    return gcd(y, x % y);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    nums = new int[N];

    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(temp[i]);
    }
    X = Integer.parseInt(br.readLine());
    int cnt = 0;
    long sum = 0;
    for (int i = 0; i < N; i++) {
      if(gcd(nums[i], X) != 1) continue;
      sum += nums[i];
      cnt++;
    }

    System.out.println(Math.round((double)sum / cnt));
  }

}
