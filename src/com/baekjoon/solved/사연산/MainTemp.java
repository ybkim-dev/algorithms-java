package com.baekjoon.solved.사연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MainTemp {

    static int s, t;
    static HashSet<Integer> visited = new HashSet<>();

    static Operand bfs(int start) {
        Queue<Operand> queue = new LinkedList<>();
        visited.add(start);
        queue.add(new Operand(start, ""));

        while (!queue.isEmpty()) {
            // 큐에서 꺼내기
            Operand operand = queue.poll();
            if(operand.num == t) {
                return operand;
            }

            for (int k = 0; k < 3; k++) {
                long num; String operator;
                if (k == 0) {
                    num = operand.num * operand.num;
                    operator = operand.operator + "*";
                } else if (k == 1){
                    num = operand.num + operand.num;
                    operator = operand.operator + "+";
                } else {
                    num = operand.num / operand.num;
                    operator = operand.operator + "/";
                }

                if(num > t) continue;
                if(visited.contains((int)num)) continue;
                queue.add(new Operand(num, operator));
                visited.add((int)num);
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        s = Integer.parseInt(temp[0]);
        t = Integer.parseInt(temp[1]);
        if (t == s) {
            System.out.println("0");
        }
        else if(t == 1) {
            System.out.println("/");
        } else {
            Operand answer = bfs(s);
            if(answer == null) System.out.println(-1);
            else System.out.println(answer.operator);
        }
    }
}

class Operand {
    long num;
    String operator;

    public Operand(long num, String operator) {
        this.num = num;
        this.operator = operator;
    }
}