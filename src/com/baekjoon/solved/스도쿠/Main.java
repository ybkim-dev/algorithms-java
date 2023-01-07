package com.baekjoon.solved.스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int[][] sudoku;
    static ArrayList<Pixel> candidate;
    static StringBuilder sb = new StringBuilder();

    static boolean rowCheck(int num, int col) {
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][col] == num) return false;
        }
        return true;
    }

    static boolean colCheck(int num, int row) {
        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i] == num) return false;
        }
        return true;
    }

    static boolean boxCheck(int num, int r, int c) {
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if(sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isPossible(Pixel pixel, int num) {
        if(!colCheck(num, pixel.x)) return false;
        if(!rowCheck(num, pixel.y)) return false;
        if(!boxCheck(num, pixel.x / 3 * 3, pixel.y / 3 * 3)) return false;
        return true;
    }

    static void dfs(int index) {
        if(index == candidate.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        } else {
            for(int k = 1; k <= 9; k++) {
                if(isPossible(candidate.get(index), k)) {
                    sudoku[candidate.get(index).x][candidate.get(index).y] = k;
                    dfs(index + 1);
                    sudoku[candidate.get(index).x][candidate.get(index).y] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        candidate = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                if(temp[j].equals("0")) candidate.add(new Pixel(i, j, 0));
                sudoku[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dfs(0);
    }
}

class Pixel {
    int x;
    int y;

    int num;

    public Pixel(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}