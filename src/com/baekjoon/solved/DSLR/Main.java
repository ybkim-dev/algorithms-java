package com.baekjoon.solved.DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int T;
    static int A, B;

    static int methodD(int n) {
        return (n * 2) % 10000;
    }

    static int methodS(int n) {
        if(n >= 1) return n - 1;
        return 9999;
    }

    static int methodL(int n) {
        n = (n % 1000) * 10 + (n / 1000);
        return n;
    }

    static int methodR(int n) {
        n = (n % 10) * 1000 + n / 10;
        return n;
    }

    static HashSet<Integer> visited = new HashSet<>();
    static Number bfs(int start) {
        Queue<Number> queue = new LinkedList<>();
        visited.add(start);
        queue.add(new Number(start, ""));

        while (!queue.isEmpty()) {
            Number current = queue.poll();
            if(current.num == B) {
                return current;
            }

            for (int k = 0; k < 4; k++) {
                int num; String operator;
                if(k == 0) {
                    num = methodD(current.num);
                    operator = current.operator + "D";
                } else if (k == 1) {
                    num = methodL(current.num);
                    operator = current.operator + "L";
                } else if (k == 2) {
                    num = methodR(current.num);
                    operator = current.operator + "R";
                } else {
                    num = methodS(current.num);
                    operator = current.operator + "S";
                }

                if(visited.contains(num)) continue;
                visited.add(num);
                queue.add(new Number(num, operator));
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            visited.clear();
            String[] temp = br.readLine().split(" ");
            A = Integer.parseInt(temp[0]);
            B = Integer.parseInt(temp[1]);

            Number answer = bfs(A);
            System.out.println(answer.operator);
        }
    }
}

class Number {
    int num;
    String operator;

    public Number(int num, String operator) {
        this.num = num;
        this.operator = operator;
    }
}
