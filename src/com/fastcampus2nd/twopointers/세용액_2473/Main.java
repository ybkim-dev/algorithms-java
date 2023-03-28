package com.fastcampus2nd.twopointers.세용액_2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int[] liquids;
  static int[] ans = new int[3];
  static long liquidsSum = Long.MAX_VALUE;

  static void twoPointers(int selectedIdx) {
    int L = 0; int R = N - 1;
    while(L < R) {
      if(L == selectedIdx) L++;
      else if(R== selectedIdx) R--;
      else {
        long mixed = (long) liquids[L] + liquids[selectedIdx] + liquids[R];
        if(mixed < 0) {
          if (liquidsSum > Math.abs(mixed)) {
            liquidsSum = Math.abs(mixed);
            ans[0] = liquids[L];
            ans[1] = liquids[selectedIdx];
            ans[2] = liquids[R];
          }
          L++;
        } else if(mixed > 0) {
          if(liquidsSum > Math.abs(mixed)) {
            liquidsSum = Math.abs(mixed);
            ans[0] = liquids[L];
            ans[1] = liquids[selectedIdx];
            ans[2] = liquids[R];
          }
          R--;
        } else {
          liquidsSum = 0L;
          ans[0] = liquids[L];
          ans[1] = liquids[selectedIdx];
          ans[2] = liquids[R];
          break;
        }
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

    for (int i = 0; i < N; i++) {
      twoPointers(i);
    }

    Arrays.sort(ans);
    StringBuilder sb = new StringBuilder();
    sb.append(ans[0]).append(" ").append(ans[1]).append(" ").append(ans[2]);
    System.out.println(sb);
  }

}
