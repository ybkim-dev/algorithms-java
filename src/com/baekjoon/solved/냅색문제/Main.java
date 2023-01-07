package com.baekjoon.solved.냅색문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, C;
    static int[] weights;
    static ArrayList<Integer> left, right;

    static void makeSubset(List<Integer> list, int start, int end, int sum) {
        if(sum > C) return;
        if(start == end) {
            list.add(sum);
            return;
        }
        makeSubset(list, start + 1, end, sum);
        makeSubset(list, start + 1, end, sum + weights[start]);
    }

    static int upperBound(int start, int end, int target) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(right.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);
        weights = new int[N];
        temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(temp[i]);
        }
        left = new ArrayList<>();
        right = new ArrayList<>();

        makeSubset(left, 0, N / 2, 0);
        makeSubset(right, N/2, N, 0);

        Collections.sort(right, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int cnt = 0;
        int index = 0;
        for(int i = 0; i < left.size(); i++) {
            index = upperBound(0, right.size() - 1, C - left.get(i));
            cnt += (index + 1);
        }
        System.out.println(cnt);
    }
}
