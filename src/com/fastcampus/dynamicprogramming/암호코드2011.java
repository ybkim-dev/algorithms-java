package com.fastcampus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호코드2011 {
    static int[] DP;

    static boolean check(char A, char B) {  // 'AB' 라는 두 자리 숫자가 하나의 수로 해독이 가능한가?
        if (A == '0') return false;
        if (A == '1') return true;
        if (A >= '3') return false;
        return B <= '6';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int length = code.length();
        DP = new int[length];
        if(code.charAt(0) != '0') {
            DP[0] = 1;
        }


        for(int i = 1; i < length; i++) {
            if(code.charAt(i) != '0') {
                DP[i] = DP[i-1];
            }
            if(check(code.charAt(i-1), code.charAt(i))) {
                if(i >= 2) {
                    DP[i] = (DP[i] + DP[i-2]);
                } else {
                    DP[i] += 1;

                }
                DP[i] %= 1000000;
            }
        }

        System.out.println(DP[length-1]);
    }
}
