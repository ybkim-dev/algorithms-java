package com.fastcampus2nd.parametricsearch.예산_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] money;
  static int totalMoney;
  static int maxMoney;

  static boolean determinate(int standard) {
    long sum = 0;
    for (int i = 0; i < money.length; i++) {
      sum += Math.min(money[i], standard);
    }
    return sum <= totalMoney;
  }

  static int parametricSearch() {
    int left = 0; int right = maxMoney;
    int ans = 0;
    while(left <= right) {
      int mid = (left + right) / 2;
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
    N = Integer.parseInt(br.readLine());
    money = new int[N];
    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      money[i] = Integer.parseInt(temp[i]);
      if(maxMoney < money[i]) {
        maxMoney = money[i];
      }
    }
    totalMoney = Integer.parseInt(br.readLine());

    int ans = parametricSearch();
    System.out.println(ans);
  }

}
