package com.baekjoon.solved.도서관;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;

    static Integer[] book;
    static int answer;

    static void solve() {
        // 좌, 우 중 큰 값의 위치 찾기
        boolean first = true;
        int left = book[0];
        int leftIndex = 0;
        int right = book[N - 1];
        int rightIndex = N - 1;
        while(true) {
            if(leftIndex > rightIndex) break;
            if(left < 0 && right < 0) {
                // left 비워주기
                for(int i = 0; i < M; i++) {
                    if(book[leftIndex] < 0) leftIndex++;
                    else break;
                    if(leftIndex >= N) break;
                }
                if(first) {
                    answer += Math.abs(left);
                    first = false;
                } else {
                    answer += (Math.abs(left) * 2);
                }
                if (leftIndex >= N) return;
                left = book[leftIndex];
            } else if(left > 0 && right > 0) {
                // right 비워주기
                for(int i = 0; i < M; i++) {
                    if(book[rightIndex] > 0) rightIndex--;
                    else break;
                    if(rightIndex < 0) break;
                }
                if(first) {
                    answer += Math.abs(right);
                    first = false;
                } else {
                    answer += (Math.abs(right) * 2);
                }
                if(rightIndex < 0) return;
                right = book[rightIndex];
            }
            else {
                if(Math.abs(left) <= Math.abs(right)) {
                    for(int i = 0; i < M; i++) {
                        if(book[rightIndex] > 0) rightIndex--;
                        else break;
                        if(rightIndex < 0) break;
                    }
                    if(first) {
                        answer += Math.abs(right);
                        first = false;
                    } else {
                        answer += (Math.abs(right) * 2);
                    }
                    if(rightIndex < 0) return;
                    right = book[rightIndex];
                } else {
                    for(int i = 0; i < M; i++) {
                        if(book[leftIndex] < 0) leftIndex++;
                        else break;
                        if(leftIndex >= N) break;
                    }
                    if(first) {
                        answer += Math.abs(left);
                        first = false;
                    } else {
                        answer += (Math.abs(left) * 2);
                    }
                    if (leftIndex >= N) return;
                    left = book[leftIndex];
                }
                // 큰 값의 위치에서 최대 갯수만큼 빼서 더하기
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        book = new Integer[N];
        temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            book[i] = Integer.parseInt(temp[i]);
        }

        // sort
        Arrays.sort(book);
        solve();

        System.out.println(answer);
    }
}
