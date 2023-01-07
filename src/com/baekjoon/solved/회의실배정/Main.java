package com.baekjoon.solved.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Job> jobs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        jobs = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.end == o2.end) return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            jobs.add(new Job(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        int curEnd = 0;
        int count = 0;
        while (!jobs.isEmpty()) {
            Job job = jobs.poll();
            if(job.start < curEnd) continue;
            curEnd = job.end;
            count++;
        }

        System.out.println(count);
    }
}

class Job {
    int start;
    int end;

    public Job(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
