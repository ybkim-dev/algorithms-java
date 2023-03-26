package com.fastcampus2nd.parametricsearch.랜선자르기_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int K, N;
  static int[] lans;

  static boolean determinate(long height) {
    long count = 0;
    for (int i = 0; i < lans.length; i++) {
      count += (lans[i] / height);
    }
    return count >= N;
  }

  static long parametricSearch() {
    long left = 1; long right = Integer.MAX_VALUE;
    long ans = 0;
    while(left <= right) {
      long mid = (left + right) / 2;
      if(determinate(mid)) {
        ans = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    K = Integer.parseInt(temp[0]);
    N = Integer.parseInt(temp[1]);

    lans = new int[K];
    for (int i = 0; i < K; i++) {
      lans[i] = Integer.parseInt(br.readLine());
    }

    long ans = parametricSearch();
    System.out.println(ans);
  }

}
