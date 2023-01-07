package com.baekjoon.solved.스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2 {
    static int[][] puzzle;
    static ArrayList<Point> candidates;

    static int candidateSize;
    static StringBuilder sb = new StringBuilder();
    // Rule:
    // 1. 가로줄 check
    // 2. 세로줄 check
    // 3. 작은 박스 check
    static boolean rowCheck(int row, int num) {
        boolean possible = true;
        for(int i = 0; i < 9; i++) {
            if(puzzle[row][i] == num) {
                possible =false;
                break;
            }
        }
        return possible;
    }

    static boolean colCheck(int col, int num) {
        boolean possible = true;
        for(int i = 0; i < 9; i++) {
            if(puzzle[i][col] == num) {
                possible = false;
                break;
            }
        }
        return possible;
    }

    static boolean boxCheck(int row, int col, int num) {
        boolean possible = true;
        for (int r = row / 3 * 3; r < row / 3 * 3 + 3; r++) {
            for (int c = col / 3 * 3; c < col / 3 * 3 + 3; c++) {
                if(puzzle[r][c] == num) {
                    possible = false;
                    break;
                }
            }
        }
        return possible;
    }

    static boolean isPossible(int row, int col, int num) {
        if(rowCheck(row, num) && colCheck(col, num) && boxCheck(row, col, num)) return true;
        else return false;
    }
    static void dfs(int k) {
        if(k == candidateSize) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(puzzle[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);

        } else {
            for(int i = 0; i < 9; i++) {
                if(isPossible(candidates.get(k).x, candidates.get(k).y, i+1)) {
                    // 넣을 수 있다면 넣기
                    puzzle[candidates.get(k).x][candidates.get(k).y] = i+1;
                    dfs(k + 1);
                    puzzle[candidates.get(k).x][candidates.get(k).y] = 0;
                }

            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        puzzle = new int[9][9];
        candidates = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = Integer.parseInt(temp[j]);
                if (puzzle[i][j] == 0) {
                    candidates.add(new Point(i, j));
                }
            }
        }

        candidateSize = candidates.size();
        dfs(0);


    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}