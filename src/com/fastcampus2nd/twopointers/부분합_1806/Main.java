package com.fastcampus2nd.twopointers.부분합_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, S;
  static int[] numbers;
  static int minLength = 100001;

  static void twoPointers() {
    int R = 0;
    int current = 0;

    for(int L = 1; L <= N; L++) {
      current -= numbers[L - 1];
      while(R + 1 <= N && current < S) {
        R++;
        current += numbers[R];
      }
      if(current >= S) {
        if(minLength > R - L + 1) {
          minLength = R - L + 1;
        }
      }
    }
    if(minLength == 100001) minLength = 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    S = Integer.parseInt(temp[1]);

    numbers = new int[N + 1];
    temp = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      numbers[i] = Integer.parseInt(temp[i-1]);
    }

    twoPointers();

    System.out.println(minLength);

  }

}
