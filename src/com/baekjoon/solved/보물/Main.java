package com.baekjoon.solved.보물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> pqA = new PriorityQueue<>();
    static PriorityQueue<Integer> pqB = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        String[] tempA = br.readLine().split(" ");
        String[] tempB = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tempA[i]);
            pqA.add(A[i]);
            B[i] = Integer.parseInt(tempB[i]);
            pqB.add(B[i]);
        }
        int ans = 0;
        while (!pqA.isEmpty()) {
            ans += (pqA.poll() * pqB.poll());
        }

        System.out.println(ans);
    }
}
