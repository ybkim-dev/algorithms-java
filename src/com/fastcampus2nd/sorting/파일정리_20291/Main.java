package com.fastcampus2nd.sorting.파일정리_20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
  static String[] executors;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    executors = new String[N];
    for (int i = 0; i < N; i++) {
      executors[i] = br.readLine().split("\\.")[1];
    }

    List<String> ansExecutors = new ArrayList<>();
    List<Integer> ansCnt = new ArrayList<>();

    Arrays.sort(executors);
    String prevExecutor = executors[0];
    int cnt = 1;

    for (int i = 1; i < N; i++) {
      if(executors[i].equals(prevExecutor)) {
        cnt++;
      } else {
        ansExecutors.add(prevExecutor);
        ansCnt.add(cnt);
        prevExecutor = executors[i];
        cnt = 1;
      }
    }
    ansExecutors.add(prevExecutor);
    ansCnt.add(cnt);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ansCnt.size(); i++) {
      sb.append(ansExecutors.get(i)).append(" ").append(ansCnt.get(i)).append("\n");
    }

    System.out.println(sb);
  }

}
