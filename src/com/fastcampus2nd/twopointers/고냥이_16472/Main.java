package com.fastcampus2nd.twopointers.고냥이_16472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static char[] sentence;
  static int[] alphabet = new int[26];
  static int ans = 0;

  static void twoPointers(int length) {
    int R = 0; int alphabetCount = 0;
    for(int L = 1; L <= length; L++) {
      if(L != 1) {
        alphabet[sentence[L-1] - 'a']--;
        if(alphabet[sentence[L-1]- 'a'] == 0) alphabetCount--;
      }

      while(R+1 <= length) {
        if(alphabetCount ==N && alphabet[sentence[R+1]-'a'] == 0) break;
        R++;
        if(alphabet[sentence[R] - 'a']== 0) alphabetCount++;
        alphabet[sentence[R] - 'a']++;
      }

      ans = Math.max(ans, R - L + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    String temp = br.readLine();
    sentence = new char[temp.length() + 1];
    for (int i = 0; i < temp.length(); i++) {
      sentence[i + 1] = temp.charAt(i);
    }

    twoPointers(temp.length());
    System.out.println(ans);
  }

}
