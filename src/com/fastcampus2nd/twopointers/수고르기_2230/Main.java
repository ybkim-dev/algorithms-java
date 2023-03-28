package com.fastcampus2nd.twopointers.수고르기_2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N, M;
  static int[] numbers;
  static int minDifference = 2_000_000_001;
  static void twoPointers(){
    int R = 1;
    for (int L = 1; L <= N; L++) {

      while(R + 1 <= N && numbers[R] - numbers[L] < M) {
        R++;
      }
      if(numbers[R] - numbers[L] >= M) {
        minDifference = Math.min(minDifference, numbers[R] - numbers[L]);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);
    numbers = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(numbers);
    twoPointers();
    System.out.println(minDifference);
  }

}
