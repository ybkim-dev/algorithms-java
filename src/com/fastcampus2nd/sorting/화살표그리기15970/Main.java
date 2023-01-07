package com.fastcampus2nd.sorting.화살표그리기15970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Point implements Comparable<Point>{
        int idx;
        int color;

        public Point(int idx, int color) {
            this.idx = idx;
            this.color = color;
        }

        @Override
        public int compareTo(Point o) {
            return idx - o.idx;
        }
    }
    static int N;
    static Point[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        points = new Point[N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            points[i] = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        Arrays.sort(points);
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int nearest = 100_000;
            int left = i - 1; int right = i + 1;
            while(left >= 0) {
                if(points[left].color == points[i].color) {
                    if(points[i].idx - points[left].idx < nearest) {
                        nearest = points[i].idx - points[left].idx;
                    }
                    break;
                }
                left -= 1;
            }
            while(right < N) {
                if(points[i].color == points[right].color) {
                    if(points[right].idx - points[i].idx < nearest) {
                        nearest = points[right].idx - points[i].idx;
                    }
                    break;
                }
                right += 1;
            }
            sum += nearest;
        }
        System.out.println(sum);
    }
}
