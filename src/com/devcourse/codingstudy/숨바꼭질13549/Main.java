package com.devcourse.codingstudy.숨바꼭질13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, K;
    static int[] map = new int[100001];
    static int[] dx = {1, -1};
    static int ans;
    static void bfs(int start) {
        Point startPoint = new Point(start, 0);
        map[start] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if(curr.x == K) {
                ans = curr.cnt;
            }
            for (int k = 0; k < 2; k++) {
                int nx = curr.x + dx[k];
                if(nx < 0 || nx >= 100001) continue;
                // 이미 다른 숫자가 방문한 상태라면!
                if(map[nx] <= curr.cnt) continue;
                map[nx] = curr.cnt + 1;
                queue.add(new Point(nx, curr.cnt + 1));
            }
            int nx = curr.x * 2;
            if(nx < 0 || nx >= 100001) continue;
            if(map[nx] <= curr.cnt) continue;
            map[nx] = curr.cnt;
            queue.add(new Point(nx, curr.cnt));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);
        for (int i = 0; i < 100001; i++) {
            map[i] = 100001;
        }

        bfs(N);
        System.out.println(ans);
    }

}

class Point {
    int x;
    int cnt;

    public Point(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}
