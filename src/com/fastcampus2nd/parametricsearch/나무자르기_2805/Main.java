package com.fastcampus2nd.parametricsearch.나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[] trees;

  static boolean satisfyingHeight(int height) {
    long sum = 0;
    for (int i = 0; i < trees.length; i++) {
      sum += Math.max(trees[i] - height,0);
    }
    return sum >= M;
  }

  static int parametricSearch() {
    int left = 0; int right = 1_000_000_000;
    int result = 0;
    while(left <= right) {
      int mid = (left + right) / 2;
      if(satisfyingHeight(mid)) {
        result = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    trees = new int[N];
    temp = br.readLine().split(" ");
    for (int i = 0; i < trees.length; i++) {
      trees[i] = Integer.parseInt(temp[i]);
    }

    int ans = parametricSearch();

    System.out.println(ans);
  }

}
