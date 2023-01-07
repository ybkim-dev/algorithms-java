package com.fastcampus.twopointers.고냥이16472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static char[] characters;
    static int[] count = new int[26];

    static int ans = 0;
    static int kind;
    static void twoPointers() {
        int L = 0; int R = 0;
        for (R = 0; R < characters.length; R++) {
            // R 이동
            count[characters[R] - 'a']++;


            while(true) {
                kind = 0;
                for (int i = 0; i < 26; i++) {
                    if(count[i] != 0) kind++;
                }

                if( kind <= N) break;
                count[characters[L] - 'a']--;
                L++;
            }
            ans = Math.max(ans, R - L + 1);
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        String[] temp = br.readLine().split("");
        characters = new char[temp.length];
        for (int i = 0; i < temp.length; i++) {
            characters[i] = temp[i].charAt(0);
        }

        twoPointers();
        System.out.println(ans);
    }
}
