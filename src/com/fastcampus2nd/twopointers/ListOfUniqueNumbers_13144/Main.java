package com.fastcampus2nd.twopointers.ListOfUniqueNumbers_13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] numbers;
  static long cnt;
  static int[] count;

  static void twoPointers() {
    int R = 0;
    for(int L = 1; L <= N; L++) {
      count[numbers[L-1]] = 0;

      while(R + 1 <= N && count[numbers[R+1]] == 0) {
        R++;
        count[numbers[R]]++;
      }

      cnt += (R - L + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    numbers = new int[N+1];
    String[] temp = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      numbers[i] = Integer.parseInt(temp[i - 1]);
    }
    count = new int[100001];

    twoPointers();
    System.out.println(cnt);
  }

}
