package com.fastcampus2nd.twopointers.귀여운라이언_15565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, K;
  static int[] dolls;
  static int minLength = 1_000_001;


  static void twoPointers() {
    int R = 0; int dollCount = 0;
    for(int L = 1; L <= N; L++) {
      if(dolls[L-1] == 1) dollCount--;

      while (R + 1 <= N && dollCount < K) {
        R++;
        if(dolls[R] == 1) {
          dollCount++;
        }
      }

      if(dollCount == K) {
        minLength = Math.min(minLength, R - L + 1);
      }
    }
    if(minLength == 1_000_001) minLength = -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    K = Integer.parseInt(temp[1]);
    dolls = new int[N + 1];
    temp = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      dolls[i] = Integer.parseInt(temp[i - 1]);
    }

    twoPointers();
    System.out.println(minLength);
  }

}
