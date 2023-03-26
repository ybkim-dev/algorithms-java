package com.fastcampus2nd.binarysearch.수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N, M;
  static int[] A, B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N];
    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < temp.length; i++) {
      A[i] = Integer.parseInt(temp[i]);
    }
    M = Integer.parseInt(br.readLine());
    B = new int[M];
    temp = br.readLine().split(" ");
    for (int i = 0; i < B.length; i++) {
      B[i] = Integer.parseInt(temp[i]);
    }

    Arrays.sort(A);

    for (int i = 0; i < B.length; i++) {
      System.out.println(existInA(B[i]));
    }
  }

  static int existInA(int target) {
    int left = 0; int right = N - 1;
    int ans = 0;
    while(left <= right) {
      int mid = (left + right) /2;
      if(A[mid] < target) {
        left = mid + 1;
      } else if( A[mid] > target) {
        right = mid - 1;
      }else {
        ans = 1;
        break;
      }
    }
    return ans;
  }

}
