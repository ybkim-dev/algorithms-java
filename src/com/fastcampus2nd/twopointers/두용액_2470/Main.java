package com.fastcampus2nd.twopointers.두용액_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int[] liquids;
  static int sum = 2_000_000_001;
  static int[] ans = new int[2];

  static void twoPointers() {
    int L = 0;
    int R = N - 1;
    while(L < R) {
      if(Math.abs(liquids[L] + liquids[R]) < sum) {
        sum = Math.abs(liquids[L] + liquids[R]);
        ans[0] = liquids[L];
        ans[1] = liquids[R];
      }

      if(liquids[L] + liquids[R] > 0) {
        R--;
      } else if(liquids[L] + liquids[R] < 0) {
        L++;
      } else {
        break;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    String[] temp = br.readLine().split(" ");
    liquids = new int[N];
    for (int i = 0; i < N; i++) {
      liquids[i] = Integer.parseInt(temp[i]);
    }

    Arrays.sort(liquids);
    twoPointers();

    StringBuilder sb = new StringBuilder();
    sb.append(ans[0]).append(" ").append(ans[1]);
    System.out.println(sb);
  }

}
