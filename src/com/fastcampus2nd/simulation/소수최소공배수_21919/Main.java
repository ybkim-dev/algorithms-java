package com.fastcampus2nd.simulation.소수최소공배수_21919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;
  static int[] nums;
  static boolean[] isPrimes;
  static boolean[] check;
  static long ans = 1;

  static void makePrime() {
    for(int i = 2; i <= 1000000; i++) {
      if(check[i] == false) {
        isPrimes[i] = true;
        for (int j = 1; i * j <= 1000000; j++) {
          check[i * j] = true;
        }
      }
    }
  }

  static void solve() {
    for (int i = 0; i < nums.length; i++) {
      if(isPrimes[nums[i]]) {
        ans *= nums[i];
        isPrimes[nums[i]] = false;
      }
    }
  }




  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    nums = new int[N];
    isPrimes = new boolean[1000001];
    check = new boolean[1000001];

    makePrime();

    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(temp[i]);
    }

    solve();
    if (ans == 1) {
      System.out.println(-1);
    } else {
      System.out.println(ans);
    }
  }

}
