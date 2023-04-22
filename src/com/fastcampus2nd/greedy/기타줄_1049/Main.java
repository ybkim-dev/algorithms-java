package com.fastcampus2nd.greedy.기타줄_1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int N, M;
  static int[] sets;
  static int[] single;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);
    sets = new int[M];
    single = new int[M];

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      sets[i] = Integer.parseInt(temp[0]);
      single[i] = Integer.parseInt(temp[1]);
    }

    Arrays.sort(sets);
    Arrays.sort(single);

    int min = Integer.MAX_VALUE;
    // 낱개 N개 vs 묶음 vs 묶음 + 낱개
    min = Math.min(single[0] * N, ((N / 6) + 1) * sets[0]);
    min = Math.min(min, (N / 6) * sets[0] + (N % 6) * single[0]);

    System.out.println(min);
  }

}
