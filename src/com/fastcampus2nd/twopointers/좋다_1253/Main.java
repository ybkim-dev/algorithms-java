package com.fastcampus2nd.twopointers.좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int[] numbers;
  static int cnt;

  static void twoPointers(int xIndex, int target) {
    int L = 0; int R = N - 1;
    while(L < R) {
      if(L == xIndex) {
        L++;
        continue;
      } else if(R == xIndex) {
        R--;
        continue;
      }

      if(numbers[L] + numbers[R] > target) {
        R--;
      } else if(numbers[L] + numbers[R] < target) {
        L++;
      } else {
        cnt++;
        break;
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

    Arrays.sort(numbers);
    for (int i = 0; i < N; i++) {
      twoPointers(i, numbers[i]);
    }

    System.out.println(cnt);
  }

}
