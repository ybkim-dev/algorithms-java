package com.baekjoon.solved.AToB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int A = Integer.parseInt(temp[0]);
        int B = Integer.parseInt(temp[1]);

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(String.valueOf(A), 0));
        int ans = -1;
        while (!queue.isEmpty()) {
            Info curr = queue.poll();
            if (curr.status.equals(String.valueOf(B))) {
                ans = curr.cnt;
                break;
            }
            // * 2
            if(Long.parseLong(curr.status) > 1000000000) continue;
            queue.add(new Info(String.valueOf(Integer.parseInt(curr.status) * 2), curr.cnt + 1));
            queue.add(new Info(curr.status + "1", curr.cnt + 1));
        }

        if(ans == -1) System.out.println(-1);
        else System.out.println(ans + 1);
    }

}

class Info {
    String status;
    int cnt;

    public Info(String status, int cnt) {
        this.status = status;
        this.cnt = cnt;
    }
}
