package com.fastcampus2nd.tree.트리순회_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int N;
  static ArrayList<Character>[] adj;
  static StringBuilder sb = new StringBuilder();

  static void preOrder(char node) {
    if(node == '.') return;
    sb.append(node);
    preOrder(adj[node - 'A'].get(0));
    preOrder(adj[node - 'A'].get(1));
  }

  static void inOrder(char node) {
    if(node == '.') return;
    inOrder(adj[node - 'A'].get(0));
    sb.append(node);
    inOrder(adj[node - 'A'].get(1));
  }

  static void postOrder(char node) {
    if(node == '.') return;
    postOrder(adj[node - 'A'].get(0));
    postOrder(adj[node - 'A'].get(1));
    sb.append(node);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    adj = new ArrayList[26];
    for (int i = 0; i < 26; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      String[] temp = br.readLine().split(" ");
      char parent = temp[0].charAt(0);
      char left = temp[1].charAt(0);
      char right = temp[2].charAt(0);
      adj[parent - 'A'].add(left);
      adj[parent - 'A'].add(right);
    }

    preOrder('A');
    sb.append("\n");
    inOrder('A');
    sb.append("\n");
    postOrder('A');
    sb.append("\n");

    System.out.println(sb);
  }

}
