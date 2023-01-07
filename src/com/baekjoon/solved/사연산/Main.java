package com.baekjoon.solved.사연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int s, t;

    static HashSet<Integer> visited = new HashSet<>();

    static Number bfs(int start) {
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(start, ""));
        visited.add(start);

        while (!queue.isEmpty()) {
            Number number = queue.poll();
            if(number.num == t) {
                return number;
            }

            // *, +, / 순으로 진행 ( -는 어차피 0을 내주게 되는데 t는 0이 나오지 않아서 쓰면 안됨.)
            for (int i = 0; i < 3; i++) {
                long temp = number.num;
                if(i ==0 ) temp *= temp;
                else if(i == 1) temp += temp;
                else if(i == 2) temp /= temp;

                // t보다 크면 의미가 없음 클 때 - 연산하면 0이고 / 연산하면 1인데 main 로직에서 처리할 것임.
                if(temp > t) continue;
                if(visited.contains((int) temp)) continue;

                if(i ==0) queue.add(new Number((int) temp, number.operators + "*"));
                else if(i==1) queue.add(new Number((int) temp, number.operators + "+"));
                else if(i == 2) queue.add(new Number((int) temp, number.operators + "/"));

                visited.add((int) temp);
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        s = Integer.parseInt(temp[0]);
        t = Integer.parseInt(temp[1]);

        if(s == t) System.out.println("0");
        else if(t == 1) System.out.println("/");
        else {
            Number ans = bfs(s);
            if(!visited.contains(t)) System.out.println("-1");
            else {
                System.out.println(ans.operators);
            }
        }
    }
}

class Number {
    int num;
    String operators;

    public Number(int num, String operators) {
        this.num = num;
        this.operators = operators;
    }
}