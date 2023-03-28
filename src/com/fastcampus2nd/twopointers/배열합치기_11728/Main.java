package com.fastcampus2nd.twopointers.배열합치기_11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[] A;
  static int[] B;
  static int[] ans;

  static void twoPointers() {
    int L = 0; int R = 0;
    int idx = 0;
    while(true) {
      if(A[L] < B[R]) {
        ans[idx] = A[L];
        L++;
        idx ++;
      } else {
        ans[idx] = B[R];
        R++;
        idx++;
      }
      if(L == N || R == M) break;
    }

    if(L < N) {
      for (int i = L; i < N; i++) {
        ans[idx] = A[i];
        idx++;
      }
    } else if(R < M) {
      for (int i = R; i < M; i++) {
        ans[idx] = B[i];
        idx++;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    A = new int[N];
    B = new int[M];
    ans = new int[N + M];
    temp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(temp[i]);
    }
    temp = br.readLine().split(" ");
    for (int i = 0; i < M; i++) {
      B[i] = Integer.parseInt(temp[i]);
    }

    twoPointers();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ans.length; i++) {
      sb.append(ans[i]).append(" ");
    }
    System.out.println(sb);
  }

}
