package com.fastcampus2nd.binarysearch.먹을것인가먹힐것인가_7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int T;
  static int[] A, B;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String[] temp = br.readLine().split(" ");
      N = Integer.parseInt(temp[0]);
      M = Integer.parseInt(temp[1]);
      A = new int[N];
      B = new int[M];
      temp = br.readLine().split(" ");
      for (int i = 0; i < temp.length; i++) {
        A[i] = Integer.parseInt(temp[i]);
      }
      temp = br.readLine().split(" ");
      for (int i = 0; i < temp.length; i++) {
        B[i] = Integer.parseInt(temp[i]);
      }

      Arrays.sort(B);
      int ans = 0;
      for (int i = 0; i < A.length; i++) {
        ans += (findLowerThanA(A[i]) + 1);
      }

      System.out.println(ans);
    }
  }

  static int findLowerThanA(int target) {
    int ans = -1;
    int left = 0;
    int right = B.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (B[mid] >= target) {
        right = mid - 1;
      } else {
        ans = mid;
        left = mid + 1;
      }
    }
    return ans;
  }

}
