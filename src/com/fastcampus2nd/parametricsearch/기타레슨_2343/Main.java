package com.fastcampus2nd.parametricsearch.기타레슨_2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N, M;
  static int[] lessons;

  static boolean determinate(long size) {
    int count = 0;
    long sizeSum = 0;
    for (int i = 0; i < lessons.length; i++) {
      if(lessons[i] > size) return false;
      if(sizeSum + lessons[i] <= size) {
        sizeSum += lessons[i];
      } else {
        count++;
        sizeSum = lessons[i];
      }
    }
    count++;
    return count <= M;
  }

  // 블루레이 1개 크기 정하기
  static long parametricSearch() {
    long left = 1; long right = 1000000000L;
    long ans = 0;
    while(left <= right) {
      long mid = (left + right) / 2;
      if(determinate(mid)) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");

    N = Integer.parseInt(temp[0]);
    M = Integer.parseInt(temp[1]);
    lessons = new int[N];
    temp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      lessons[i] = Integer.parseInt(temp[i]);
    }

    long ans = parametricSearch();
    System.out.println(ans);
  }

}
