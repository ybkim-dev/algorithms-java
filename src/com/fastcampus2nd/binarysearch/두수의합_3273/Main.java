package com.fastcampus2nd.binarysearch.두수의합_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int n;
  static int[] numbers;
  static int target;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(temp[i]);
    }
    target = Integer.parseInt(br.readLine());

    Arrays.sort(numbers);

    int ans = 0;
    for (int i = 0; i < n; i++) {
      // numbers 돌면서 합을 x로 만들 수 있는 가짓수 찾기
      if(summationEqualToTarget(numbers[i], target - numbers[i])) {
        ans++;
      }
    }
    System.out.println(ans/2);
  }

  static boolean summationEqualToTarget(int number, int target) {
    int left = 0; int right = n - 1;
    while(left <= right) {
      int mid = (left + right) / 2;
      if(numbers[mid] < target) {
        left = mid + 1;
      } else if(numbers[mid] > target) {
        right = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }

}
