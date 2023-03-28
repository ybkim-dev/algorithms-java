package com.fastcampus2nd.twopointers.두수의합_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int[] numbers;
  static int x;
  static int cnt;

  static void twoPointers() {
    int L = 0; int R= N-1;
    while(L < R) {
      if(numbers[L] + numbers[R] == x) {
        cnt++;
        L++;
        R--;
      }
      else if(numbers[L] + numbers[R] > x) {
        R--;
      } else {
        L++;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    numbers = new int[N];
    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(temp[i]);
    }
    x = Integer.parseInt(br.readLine());

    Arrays.sort(numbers);
    twoPointers();
    System.out.println(cnt);
  }

}
