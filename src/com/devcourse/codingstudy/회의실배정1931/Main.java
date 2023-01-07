package com.devcourse.codingstudy.회의실배정1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static class Zoom {
        int startTime;
        int endTime;

        public Zoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static int N;
    static PriorityQueue<Zoom> zooms = new PriorityQueue<>(new Comparator<Zoom>() {
        @Override
        public int compare(Zoom o1, Zoom o2) {
            if (o1.endTime == o2.endTime) return o1.startTime - o2.startTime;
            return o1.endTime - o2.endTime;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] temp;
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            zooms.add(new Zoom(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        int ans = 0;
        int prevEndTime = 0;
        while (!zooms.isEmpty()) {
            Zoom curr = zooms.poll();
            // 이번 회의가 시작되어야 하는데 아직 회의가 안끝났다면 continue
            if(curr.startTime < prevEndTime) continue;

            ans++;
            prevEndTime = curr.endTime;
        }
        System.out.println(ans);
    }
}
