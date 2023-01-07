package com.devcourse.codingstudy.카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        if(pq.size() == 1) {
            System.out.println(0);
        } else {
            long ans = 0;
            while (!pq.isEmpty()) {
                int first = pq.poll();
                int second = pq.poll();
                ans += (first + second);
                if(pq.size() == 0) break;
                pq.add(first + second);
            }
            System.out.println(ans);
        }
    }
}
