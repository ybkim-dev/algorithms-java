package com.fastcampus2nd.binarysearch.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N, M;
  static int[] cards;
  static int[] tests;

  static int upperbound(int target) {
    int left = 1; int right = N;
    while(left <= right) {
      int mid = (left + right) / 2;
      if(cards[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  static int lowerbound(int target) {
    int left = 1; int right = N;
    while(left <= right) {
      int mid = (left + right) /2 ;
      if(cards[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    cards = new int[N + 1];
    String[] temp = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      cards[i] = Integer.parseInt(temp[i - 1]);
    }

    M = Integer.parseInt(br.readLine());
    tests = new int[M + 1];

    temp = br.readLine().split(" ");
    for (int j = 1; j <= M; j++) {
      tests[j] = Integer.parseInt(temp[j - 1]);
    }

    Arrays.sort(cards, 1, N + 1);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= M; i++) {
      int ans = 0;
      ans += upperbound(tests[i]) - lowerbound(tests[i]);
      sb.append(ans).append(" ");
    }
    System.out.println(sb);
  }

}
