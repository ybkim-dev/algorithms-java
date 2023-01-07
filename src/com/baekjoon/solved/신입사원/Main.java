package com.baekjoon.solved.신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static int T;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            ArrayList<Result> results = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] temp = br.readLine().split(" ");
                results.add(new Result(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
            }

            Collections.sort(results, Comparator.comparingInt(o -> o.paper));
            int ans = 0;
            int paperLimit = 0;
            int interviewLimit = 0;
            int start = -1; int end = -1;
            for (int i = 0; i < results.size(); i++) {
                if(results.get(i).paper == 1 && results.get(i).interview == 1) {
                    ans = 1;
                    break;
                }
                else if(results.get(i).paper == 1) {
                    ans += 1;
                    interviewLimit = results.get(i).interview;
                    start = i;
                }
                else if(results.get(i).interview == 1) {
                    ans += 1;
                    paperLimit = results.get(i).paper;
                    end = i;
                }
            }

            for (int i = start + 1; i < end; i++) {
                if (results.get(i).paper < paperLimit && results.get(i).interview < interviewLimit) {
                    interviewLimit = results.get(i).interview;
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }

    static class Result {
        int paper;
        int interview;

        public Result(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }
    }
}
