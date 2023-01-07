package com.fastcampus.tree.부동산다툼20364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int Q;
    static boolean[] get;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        Q = Integer.parseInt(temp[1]);

        get = new boolean[N + 1];

        for (int i = 1; i <= Q; i++) {
            int preference = Integer.parseInt(br.readLine());
            int tmp = preference;
            int firstMet = 0;
            while(tmp > 1) {
                if(get[tmp]) {
                    firstMet = tmp;
                }
                tmp /= 2;
            }

            get[preference] = true;
            System.out.println(firstMet);
        }
    }
}
