package com.fastcampus2nd.twopointers.블로그_21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N, X;
  static int[] days;
  static int sum;
  static int max = -1;
  static int cnt;

  static void twoPointers() {
    int R = 0;
    for (int L = 0; L < N; L++) {
      if(L > 0) {
        sum -= days[L - 1];
      }

      while(R < days.length && R - L + 1 <= X) {
        sum += days[R];
        R++;
      }

      if(max < sum) {
        max = sum;
        cnt = 1;
      } else if(sum == max) {
        cnt++;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    X = Integer.parseInt(temp[1]);
    days = new int[N];
    temp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      days[i] = Integer.parseInt(temp[i]);
    }

    twoPointers();

    if (sum == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(max);
      System.out.println(cnt);
    }
  }

}
