package com.fastcampus2nd.parametricsearch.용돈관리_6236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[] money;
  static int minMoney;

  static boolean determinate(long standard){
    int count = 0;
    long lastMoney = 0;
    for (int i = 0; i < N; i++) {
      if(money[i] > standard) return false;
      if(lastMoney + money[i] <= standard) {
        lastMoney += money[i];
      } else {
        count++;
        lastMoney = money[i];
      }
    }
    count++;
    return count <= M;
  }

  static long parametricSearch() {
    long left = minMoney;
    long right = 1_000_000_000;
    long ans = minMoney;
    while(left <= right) {
      long mid = (left + right) / 2;
      if(determinate(mid)) {
        ans = mid;
        right = mid - 1;
      } else{
        left = mid + 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    money = new int[N];
    for (int i = 0; i < N; i++) {
      money[i] = Integer.parseInt(br.readLine());
      minMoney = Math.min(minMoney, money[i]);
    }

    long ans = parametricSearch();
    System.out.println(ans);

  }

}
