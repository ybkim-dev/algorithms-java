package com.fastcampus2nd.dynamicprogramming.암호코드_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String code = br.readLine();
    int length = code.length();
    dp = new int[length];
    if(code.charAt(0) != '0') {
      dp[0] = 1;
    }

    for (int i = 1; i < length; i++) {
      if(code.charAt(i) != '0') {
        dp[i] = (dp[i] + dp[i - 1]) % 1000000;
      }
      int x = Integer.parseInt(String.valueOf(code.charAt(i)))  + 10 *  Integer.parseInt(String.valueOf(code.charAt(i - 1)));
      if(x >= 10 && x <= 26) {
        if(i >= 2) {
          dp[i] = (dp[i] + dp[i - 2]) % 1000000;
        } else {
          dp[i] += 1;
          dp[i] %= 1000000;
        }
      }
    }

    System.out.println(dp[length - 1]);
  }


}
