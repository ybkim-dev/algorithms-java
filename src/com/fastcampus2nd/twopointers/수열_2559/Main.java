package com.fastcampus2nd.twopointers.수열_2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, K;
  static int[] temperatures;

  static int twoPointers() {
    int R = 0;
    int maxSum = -10_000_001;
    int sum = 0;

    for (int L = 1; L <= N; L++) {
      sum -= temperatures[L - 1];

      while(R + 1 <= N && R - L + 1 < K) {
        R++;
        sum += temperatures[R];
      }

      if (R - L + 1 == K) {
        maxSum = Math.max(maxSum, sum);
      }
    }
    return maxSum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    K = Integer.parseInt(temp[1]);

    temperatures = new int[N + 1];
    temp = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      temperatures[i] = Integer.parseInt(temp[i - 1]);
    }

    int ans = twoPointers();
    System.out.println(ans);
  }

}
