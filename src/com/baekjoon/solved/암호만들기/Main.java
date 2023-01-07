package com.baekjoon.solved.암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int L, C;
    static boolean[] visited;
    static int[] selected;
    static int mo;
    static int ja;

    static char[] characters;
    static StringBuilder sb = new StringBuilder();

    static void findPassword(int index) {
        if(index == L+1) {
            if(mo >= 1 && ja >= 2) {
                for (int i = 1; i < index; i++) {
                    sb.append(characters[selected[i]]);
                }
                sb.append("\n");
            }
        } else {
            for (int i = selected[index-1]; i < characters.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    selected[index] = i;
                    if(characters[i] == 'a' || characters[i] == 'e' || characters[i] == 'i' || characters[i] == 'o' || characters[i] == 'u') mo+=1;
                    else ja+=1;
                    findPassword(index + 1);
                    if(characters[i] == 'a' || characters[i] == 'e' || characters[i] == 'i' || characters[i] == 'o' || characters[i] == 'u') mo-=1;
                    else ja-=1;
                    selected[index] = 0;
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        L = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);

        characters = new char[C];
        selected = new int[L+1];
        visited = new boolean[C];
        temp = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            characters[i] = temp[i].charAt(0);
        }

        Arrays.sort(characters);
        findPassword(1);
        System.out.println(sb.toString());
    }
}
