package com.fastcampus2nd.tree.이진검색트리_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static ArrayList<Integer> trees = new ArrayList<>();

  static void dfs(int left, int right) {
    if(left > right) return;
    int mid = right;
    for (int i = left + 1; i <= right; i++) {
      if(trees.get(i) > trees.get(left)) {
        mid = i - 1;
        break;
      }
    }

    dfs(left + 1, mid);
    dfs(mid + 1, right);
    System.out.println(trees.get(left));
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    try {
      while((str = br.readLine()) != null) {
        trees.add(Integer.parseInt(str));
      }
    } catch (Exception e) {

    }


    dfs(0, trees.size() - 1);
  }

}
