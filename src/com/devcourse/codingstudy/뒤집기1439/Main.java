package com.devcourse.codingstudy.뒤집기1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sent = br.readLine();

        int zero_cnt = 0;
        int one_cnt = 0;

        if(sent.charAt(0) == '0') zero_cnt++;
        else one_cnt++;

        for (int i = 1; i < sent.length(); i++) {
            if(sent.charAt(i) != sent.charAt(i-1)) {
                if(sent.charAt(i) == '0') {
                    zero_cnt += 1;
                } else one_cnt += 1;
            }
        }


        System.out.println(Math.min(one_cnt, zero_cnt));

    }
}
