package com.devcourse.codingstudy.강의실배정11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Zoom {
        int startTime;
        int endTime;

        public Zoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }


    static ArrayList<Integer> rooms = new ArrayList<>();

    static int lowerBound(int target) {
        int left = 0; int right = rooms.size() - 1;

        int temp = rooms.size();
        while(left <= right) {
            int mid = (left + right) / 2;
            if(rooms.get(mid) > target) {
                right = mid - 1;
            } else if(rooms.get(mid) < target) {
                temp = mid;
                left = mid + 1;
            } else {
                temp = mid;
            }
        }
        if(temp == rooms.size()) return -1;
        else return temp;
    }


    static int N;
    static PriorityQueue<Zoom> zooms = new PriorityQueue<>((o1, o2) -> {
        if (o1.endTime == o2.endTime) return o1.startTime - o2.startTime;
        return o1.endTime - o2.endTime;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] temp;
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            zooms.add(new Zoom(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        int roomCnt = 0;

        while (!zooms.isEmpty()) {
            Zoom curr = zooms.poll();
            if(rooms.isEmpty()) rooms.add(curr.endTime);
            else {
                boolean check = false;
                Collections.sort(rooms);
//                for(int i = 0; i < rooms.size(); i++) {
//                    if(rooms.get(i) > curr.startTime) continue;
//                    rooms.set(i, curr.endTime);
//                    check = true;
//                }
                int result = lowerBound(curr.startTime);
                if(result == -1) {
                    rooms.add(curr.endTime);
                }
                else {
                    rooms.set(result, curr.endTime);
                }
            }
        }
        System.out.println(rooms.size());
    }
}
