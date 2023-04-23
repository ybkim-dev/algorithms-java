package com.fastcampus2nd.datastructure.대칭차집합_1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");

    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    Set<Integer> setA = new HashSet<>();
    Set<Integer> setB = new HashSet<>();

    temp = br.readLine().split(" ");
    for (int i = 0; i < temp.length; i++) {
      setA.add(Integer.parseInt(temp[i]));
    }

    temp = br.readLine().split(" ");
    for (int i = 0; i < temp.length; i++) {
      setB.add(Integer.parseInt(temp[i]));
    }

    Set<Integer> AminusB = new HashSet<>();
    for(Integer element : setA) {
      AminusB.add(element);
    }

    Set<Integer> BminusA = new HashSet<>();
    for(Integer element : setB) {
      BminusA.add(element);
    }

    AminusB.removeAll(setB);
    BminusA.removeAll(setA);

    System.out.println(AminusB.size() + BminusA.size());
  }

}
