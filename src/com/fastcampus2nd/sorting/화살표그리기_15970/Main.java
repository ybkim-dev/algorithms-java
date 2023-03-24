package com.fastcampus2nd.sorting.화살표그리기_15970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  static int N;
  static ArrayList<Integer>[] points;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    points = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      points[i] = new ArrayList<>();
    }


    for (int i = 0; i < N; i++) {
      String[] temp = br.readLine().split(" ");
      points[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
    }

    for (int color = 1; color <= N; color++) {
      Collections.sort(points[color]);
    }
    int sum = 0;
    for (int color = 1; color <= N; color++) {
      for(int index = 0; index < points[color].size(); index++) {
        if(index == 0) {
          sum += points[color].get(index + 1) - points[color].get(index);
        } else if (index == points[color].size() - 1) {
          sum += points[color].get(index) - points[color].get(index - 1);
        } else {
          sum += Math.min(points[color].get(index) - points[color].get(index - 1),
              points[color].get(index + 1) - points[color].get(index));
        }
      }
    }
    System.out.println(sum);
  }

}
