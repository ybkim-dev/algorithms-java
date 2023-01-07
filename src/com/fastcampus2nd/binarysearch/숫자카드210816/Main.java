package com.fastcampus2nd.binarysearch.숫자카드210816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] cards;
    static int[] target;
    static int[] answer;

    static int lowerBound(int target) {
        int left = 0; int right = N - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(cards[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    static int upperBound(int target) {
        int left = 0; int right = N - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(cards[mid] <= target) {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(temp[i]);
        }
        M = Integer.parseInt(br.readLine());
        target = new int[M];
        answer = new int[M];
        temp = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(cards);
        for (int i = 0; i < M; i++) {
            answer[i] += (upperBound(target[i]) - lowerBound(target[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
