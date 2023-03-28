package com.fastcampus2nd.twopointers.수들의합2_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;
  static long M;
  static int[] numbers;
  static int cnt;

  static void twoPointers() {
    int R = 0; long sum = 0;
    for(int L = 1; L <= N; L++) {
      sum -= numbers[L - 1];

      while(R + 1 <= N && sum < M) {
        R++;
        sum += numbers[R];
      }

      if(sum == M) {
        cnt++;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Long.parseLong(temp[1]);
    numbers = new int[N + 1];
    temp = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      numbers[i] = Integer.parseInt(temp[i - 1]);
    }

    twoPointers();

    System.out.println(cnt);
  }

}
