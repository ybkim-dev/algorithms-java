package com.fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연산자끼워넣기14888 {
    static int[] numbers;
    static int N;
    static int[] operators;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static void recFunc(int k, int result) {
        if(k == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        } else {
            if(operators[1] > 0) {
                operators[1]--;
                recFunc(k+1, result + numbers[k+1]);
                operators[1]++;
            }
            if(operators[2] > 0) {
                operators[2]--;
                recFunc(k+1, result-numbers[k+1]);
                operators[2]++;
            }
            if(operators[3] > 0) {
                operators[3]--;
                recFunc(k+1, result * numbers[k+1]);
                operators[3]++;
            }
            if(operators[4] > 0) {
                operators[4]--;
                recFunc(k+1, result/ numbers[k+1]);
                operators[4]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        String[] temp = br.readLine().split(" ");
        for(int i = 1; i<=N;i++) {
            numbers[i] = Integer.parseInt(temp[i-1]);
        }
        operators = new int[5];
        temp =br.readLine().split(" ");
        for(int i = 1; i <= 4; i++) {
            operators[i] = Integer.parseInt(temp[i-1]);
        }
        recFunc(1, numbers[1]);
        System.out.println(max);
        System.out.println(min);
    }
}
