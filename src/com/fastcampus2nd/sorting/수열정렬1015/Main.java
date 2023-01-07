package com.fastcampus2nd.sorting.수열정렬1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static class Idx implements Comparable<Idx> {
        int num;
        int idx;

        public Idx(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Idx o) {
            return num - o.num;
        }
    }
    static int N;
    static Idx[] indices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] p = new int[N];
        indices = new Idx[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            indices[i] = new Idx(Integer.parseInt(temp[i]), i);
        }
        Arrays.sort(indices);
        for (int i = 0; i < N; i++) {
            p[indices[i].idx] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(p[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
