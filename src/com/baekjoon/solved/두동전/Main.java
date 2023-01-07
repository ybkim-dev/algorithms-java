package com.baekjoon.solved.두동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static boolean[][] visitedA;
    static boolean[][] visitedB;

    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] map;

    static int[] coins;

    static int bfs(int startXA, int startYA, int startXB, int startYB) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startXA);
        queue.add(startYA);
        queue.add(0); // cnt
        queue.add(startXB);
        queue.add(startYB);
        queue.add(0); // cnt
        visitedA[startXA][startYA] = true;
        visitedB[startXB][startYB] = true;
        while (!queue.isEmpty()) {
            // 1. queue에서 가져오기
            int xA = queue.poll();
            int yA = queue.poll();
            int cntA = queue.poll();
            int xB = queue.poll();
            int yB = queue.poll();
            int cntB = queue.poll();
            // 2. 목적지인가? --> pass
            if(cntA >= 10) break;
            // 3. 인접 노드 탐색
            for(int k = 0; k < 4; k++) {
                boolean outA = false;
                boolean outB = false;
                int nxA = xA + dx[k];
                int nyA = yA + dy[k];
                int nxB = xB + dx[k];
                int nyB = yB + dy[k];

                // 4. 갈 수 있는가?
                // 벽인 경우 --> queue에 다시 넣기
                // 공간인 경우 --> 그냥 가기
                // 범위 밖인 경우 --> flag 두고 둘다 떨어졌을 시, roll back( queue에 넣지 않음)

                if(nxA <= 0 || nxA > N || nyA <= 0 || nyA > M) {
                    outA = true;
                }
                else if(map[nxA][nyA] == '#') {
                    nxA = xA;
                    nyA = yA;
                    queue.add(nxA);
                    queue.add(nyA);
                    queue.add(cntA + 1);
                } else if(map[nxA][nyA] == '.' || map[nxA][nyA] == 'o') {
                    visitedA[nxA][nyA] = true;
                    queue.add(nxA);
                    queue.add(nyA);
                    queue.add(cntA + 1);
                }

                if(nxB <= 0 || nxB > N || nyB <= 0 || nyB > M) {
                    outB = true;
                }
                else if(map[nxB][nyB] == '#') {
                    nxB = xB;
                    nyB = yB;
                    queue.add(nxB);
                    queue.add(nyB);
                    queue.add(cntB + 1);
                } else if(map[nxB][nyB] == '.' || map[nxB][nyB] == 'o') {
                    visitedB[nxB][nyB] = true;
                    queue.add(nxB);
                    queue.add(nyB);
                    queue.add(cntB + 1);
                }

                if((outA == true && outB == false) || (outA == false && outB == true)) {
                    return cntA + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        map = new char[N + 1][M + 1];
        visitedA = new boolean[N + 1][M + 1];
        visitedB = new boolean[N + 1][M + 1];
        coins = new int[5];
        int coinIndex = 0;
        for(int i = 1; i <= N ; i++) {
            temp = br.readLine().split("");
            for(int j = 1; j <= M; j++) {
                if(temp[j-1].charAt(0) == 'o') {
                    coins[coinIndex++] = i;
                    coins[coinIndex++] = j;
                }
                map[i][j] = temp[j - 1].charAt(0);
            }
        }


        System.out.println(bfs(coins[0], coins[1], coins[2], coins[3]));
    }
}
