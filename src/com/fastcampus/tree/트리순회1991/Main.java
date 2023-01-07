package com.fastcampus.tree.트리순회1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N;

    static ArrayList<Character>[] children;

    static StringBuilder sb = new StringBuilder();

    static void preorder(char ch) {
        if(ch == '.') return;
        sb.append(ch);
        preorder(children[ch - 'A' + 1].get(0));
        preorder(children[ch - 'A' + 1].get(1));
    }

    static void inorder(char ch) {
        if(ch == '.') return;
        inorder(children[ch - 'A' + 1].get(0));
        sb.append(ch);
        inorder(children[ch - 'A' + 1].get(1));
    }

    static void postorder(char ch) {
        if(ch == '.') return;
        postorder(children[ch - 'A' + 1].get(0));
        postorder(children[ch - 'A' + 1].get(1));
        sb.append(ch);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        children = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            children[temp[0].charAt(0) - 'A' + 1].add(temp[1].charAt(0));
            children[temp[0].charAt(0) - 'A' + 1].add(temp[2].charAt(0));
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        sb.append("\n");
        System.out.println(sb.toString());

    }
}
