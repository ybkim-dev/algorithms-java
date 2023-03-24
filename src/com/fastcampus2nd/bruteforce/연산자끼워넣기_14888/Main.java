package com.fastcampus2nd.bruteforce.연산자끼워넣기_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] numbers;
  static int[] operatorCounts;
  static int min = 1_000_000_001;
  static int max = -1_000_000_001;

  static void solve(int index, int result) {
    if(index == numbers.length - 1) {
      if (result < min) {
        min = result;
      }
      if (result > max) {
        max = result;
      }
    } else {
      for (int i = 0; i < 4; i++) {
        if(operatorCounts[i] == 0) continue;
        if(i == 0) {
          operatorCounts[i]--;
          solve(index + 1, result + numbers[index + 1]);
          operatorCounts[i]++;
        } else if(i == 1) {
          operatorCounts[i]--;
          solve(index + 1, result - numbers[index + 1]);
          operatorCounts[i]++;
        } else if(i == 2) {
          operatorCounts[i]--;
          solve(index + 1, result * numbers[index + 1]);
          operatorCounts[i]++;
        } else {
          operatorCounts[i]--;
          solve(index + 1, result / numbers[index + 1]);
          operatorCounts[i]++;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    String[] temp = br.readLine().split(" ");
    numbers = new int[N];
    for (int i = 0; i < temp.length; i++) {
      numbers[i] = Integer.parseInt(temp[i]);
    }
    operatorCounts = new int[4];
    temp = br.readLine().split(" ");
    for (int i = 0; i < temp.length; i++) {
      operatorCounts[i] = Integer.parseInt(temp[i]);
    }

    solve(0, numbers[0]);
    System.out.println(max);
    System.out.println(min);
  }

}
