package com.fastcampus2nd.bruteforce.부분수열의합_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, S, cnt;
  static int[] numbers;
  static int[] check;

  static int sum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += check[i];
    }
    return sum;
  }

  static void solve(int index, int result) {
    if(index == N) {
      if(result == S && sum(check) > 0) cnt++;
    } else {
      check[index] = 1;
      solve(index + 1, result + numbers[index]);
      check[index] = 0;
      solve(index + 1, result);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    S = Integer.parseInt(temp[1]);
    numbers = new int[N];
    check = new int[N];
    temp = br.readLine().split(" ");
    for (int i = 0; i < temp.length; i++) {
      numbers[i] = Integer.parseInt(temp[i]);
    }

    solve(0,0);
    System.out.println(cnt);
  }

}
