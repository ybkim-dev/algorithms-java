package com.fastcampus2nd.simulation.전구_21918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[] bulbs;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    bulbs = new int[N + 1];
    temp = br.readLine().split(" ");
    for (int i = 0; i < temp.length; i++) {
      bulbs[i + 1] = Integer.parseInt(temp[i]);
    }

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      int instruction = Integer.parseInt(temp[0]);
      int left = Integer.parseInt(temp[1]);
      int right = Integer.parseInt(temp[2]);

      switch (instruction) {
        case 1:
          bulbs[left] = right;
          break;
        case 2:
          for(int k = left; k <= right; k++) {
            bulbs[k] = (bulbs[k] + 1) % 2;
          }
          break;
        case 3:
          for(int k = left; k <= right; k++) {
            bulbs[k] = 0;
          }
          break;
        case 4:
          for(int k = left; k <= right; k++) {
            bulbs[k] = 1;
          }
          break;
        default:
          break;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < bulbs.length; i++) {
      sb.append(bulbs[i]).append(" ");
    }

    System.out.println(sb);
  }

}
