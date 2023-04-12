package com.fastcampus2nd.tree.부동산다툼_20364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, Q;
  static int[] trees;
  static boolean[] check;
  static int obstacle;

  static void canBuyEstate(int curr) {
    if(curr ==  0) return;

    if(check[curr]) {
      obstacle = curr;
    }

    canBuyEstate(curr/ 2);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    Q = Integer.parseInt(temp[1]);

    trees = new int[N + 1];
    check = new boolean[N + 1];

    for (int i = 0; i < Q; i++) {
      obstacle = N + 1;
      int number = Integer.parseInt(br.readLine());
      canBuyEstate(number);
      if (obstacle == N + 1) {
        System.out.println(0);
        check[number] = true;
      } else {
        System.out.println(obstacle);
      }

    }
  }

}
