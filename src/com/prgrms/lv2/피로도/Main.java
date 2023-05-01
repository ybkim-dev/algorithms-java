package com.prgrms.lv2.피로도;

public class Main {

  static int N;
  static boolean[] visited;
  static int max = -1;

  static void search(int index, int k, int[][] dungeons) {
    if(index == N || k <= 0) {
      // 모두 탐색한 경우
      int count = 0;
      for(int i = 0; i < dungeons.length; i++) {
        if(visited[i]) count++;
      }
      if(count > max) {
        max = count;
      }
    } else {
      // 탐색해야 하는 경우 찾기
      for(int i = 0; i < dungeons.length; i++) {
        if(visited[i]) continue;
        if(dungeons[i][0] > k) continue;

        // 탐색하기
        visited[i] = true;
        search(index + 1, k - dungeons[i][1], dungeons);

        // 모두 탐색한 경우
        int count = 0;
        for(int j = 0; j < dungeons.length; j++) {
          if(visited[j]) count++;
        }
        if(count > max) {
          max = count;
        }
        visited[i] = false;
      }
    }
  }

  static public int solution(int k, int[][] dungeons) {
    int answer = -1;
    N = dungeons.length;
    visited= new boolean[N];

    search(0, k, dungeons);
    answer = max;
    return answer;
  }

  public static void main(String[] args) {
    solution(5, new int[][]{{5, 4}, {99, 1}, {99, 2}, {99, 3}});
  }
}
