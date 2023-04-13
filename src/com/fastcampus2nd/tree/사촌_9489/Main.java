package com.fastcampus2nd.tree.사촌_9489;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N, K;
  static int[] numbers;
  static int[] parent;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    parent = new int[1000001];
    while(true) {
      String[] temp = br.readLine().split(" ");
      N = Integer.parseInt(temp[0]);
      K = Integer.parseInt(temp[1]);

      if(N == 0 && K == 0) {
        break;
      }

      numbers = new int[N];
      Arrays.fill(parent, 0);

      temp = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
        numbers[i] = Integer.parseInt(temp[i]);
      }


      int currParentIndex = -1;
      for (int i = 1; i < N; i++) {
        if(numbers[i-1] + 1 < numbers[i]) {
          currParentIndex++;
        }
        parent[numbers[i]] = numbers[currParentIndex];
      }

      int ans = 0;
      for (int i = 1; i <= 1000000; i++) {
        if(parent[K] == 0 || parent[i] ==0 || parent[parent[i]] == 0) continue;
        if (parent[parent[i]] == parent[parent[K]] && parent[i] != parent[K]) {
          ans++;
        }
      }
      System.out.println(ans);

    }

  }

}
