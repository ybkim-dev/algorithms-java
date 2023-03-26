package com.fastcampus2nd.binarysearch.듣보잡_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N, M;
  static String[] listens;
  static String[] sees;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);

    listens = new String[N];
    sees = new String[M];

    for (int i = 0; i < N; i++) {
      listens[i] = br.readLine();
    }
    for (int i = 0; i < M; i++) {
      sees[i] = br.readLine();
    }
    Arrays.sort(listens);
    Arrays.sort(sees);
    int ans = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      if (existsInSees(listens[i])) {
        ans++;
        sb.append(listens[i]).append("\n");
      }
    }

    System.out.println(ans);
    System.out.println(sb);
  }

  static boolean existsInSees(String target) {
    int left = 0; int right = M - 1;
    while(left <= right) {
      int mid = (left + right) / 2;
      if(sees[mid].equals(target)) {
        return true;
      } else if(sees[mid].compareTo(target) < 0 ){
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

}
