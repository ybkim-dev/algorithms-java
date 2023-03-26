package com.fastcampus2nd.binarysearch.두용액_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int[] acids;
  static int ans = 2_000_000_001;
  static int[] ansList = new int[2];

  static void binarySearch() {
    int left = 1; int right = N;
    while(left < right) {
      if(Math.abs(acids[left] + acids[right]) < ans) {
        ans = Math.abs(acids[left] + acids[right]);
        ansList[0] = acids[left];
        ansList[1] = acids[right];
      }

      if(acids[left] + acids[right] < 0) {
        left++;
      } else {
        right--;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    acids = new int[N + 1];
    String[] temp = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      acids[i] = Integer.parseInt(temp[i - 1]);
    }

    Arrays.sort(acids, 1, N + 1);
    binarySearch();
    StringBuilder sb = new StringBuilder();
    sb.append(ansList[0]).append(" ").append(ansList[1]);
    System.out.println(sb);
  }

}
