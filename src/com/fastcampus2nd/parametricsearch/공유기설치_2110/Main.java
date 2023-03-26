package com.fastcampus2nd.parametricsearch.공유기설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N, C;
  static int[] houses;

  static boolean determination(int dist) {
    int count = 1;
    int lastHouse = houses[0];
    for (int i = 1; i < houses.length; i++) {
      if(houses[i] - lastHouse >= dist) {
        count++;
        lastHouse = houses[i];
      }
    }
    return count >= C;
  }

  static int parametricSearch() {
    int left = 1; int right = 1_000_000_000;
    int ans = 0;
    while(left <= right) {
      int mid = (left + right) / 2;
      if (determination(mid)) {
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

    N = Integer.parseInt(temp[0]);
    C = Integer.parseInt(temp[1]);

    houses = new int[N];
    for (int i = 0; i < N; i++) {
      houses[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(houses);

    int ans = parametricSearch();
    System.out.println(ans);
  }

}
