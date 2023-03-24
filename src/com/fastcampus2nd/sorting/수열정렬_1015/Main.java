package com.fastcampus2nd.sorting.수열정렬_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  static int N;
  static List<Elem> elems = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < temp.length; i++) {
      elems.add(new Elem(Integer.parseInt(temp[i]), i));
    }

    Collections.sort(elems);
    int[] p = new int[N];
    for (int i = 0; i < elems.size(); i++) {
      p[elems.get(i).idx] = i;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < p.length; i++) {
      sb.append(p[i]).append(" ");
    }
    System.out.println(sb);
  }

  static class Elem implements Comparable<Elem> {

    int number;
    int idx;

    @Override
    public int compareTo(Elem other) {
      return number - other.number;
    }

    public Elem(int number, int idx) {
      this.number = number;
      this.idx = idx;
    }
  }
}
