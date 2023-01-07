package com.baekjoon.solved.탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] dp; // visit 겸 이동거리 check 배열
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        R = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);

        map = new char[R][C];
        dp = new int[R][C];

        Queue<Point> queue = new LinkedList<>();
        Point start = null;
        Point target = null;
        for (int r = 0; r < R; r++) {
            temp = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                map[r][c] = temp[c].charAt(0);
                if(map[r][c] == '*') {
                    queue.add(new Point(r, c, '*'));
                } else if(map[r][c] == 'S') {
                    start = new Point(r, c, 'S');
                } else if(map[r][c] == 'D') {
                    target = new Point(r, c, 'D');
                }

            }
        }

        // 고슴도치 넣기
        queue.add(start);

        // Queue ['*', 'S']
        boolean foundAnswer = false;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            // 목적지인가?
            if(p.type == 'D') {
                foundAnswer = true;
                break;
            }

            // 연결된 곳 순회
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if(p.type == 'S' || p.type == '.') {
                    // 갈 수 있는가? 고슴도치 : . or D, 방문하지 않은 곳
                    if ((map[nx][ny] == '.' || map[nx][ny] == 'D') && dp[nx][ny] == 0) {
                        dp[nx][ny] = dp[p.x][p.y] + 1;
                        queue.add(new Point(nx, ny, map[nx][ny]));
                    }
                } else if(p.type =='*') {
                    // 갈 수 있는가? 물 : . or S , 방문하든 안하든 갈 수 있음
                    if(map[nx][ny] == '.' || map[nx][ny] == 'S') {
                        map[nx][ny] = '*';
                        queue.add(new Point(nx, ny, '*'));
                    }
                }

            }
        }

        if(foundAnswer) System.out.println(dp[target.x][target.y]);
        else System.out.println("KAKTUS");
    }
}

class Point {
    int x;
    int y;
    int type;

    public Point(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}