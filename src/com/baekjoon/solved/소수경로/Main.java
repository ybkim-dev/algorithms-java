package com.baekjoon.solved.소수경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[] visited;
    static boolean[] prime;
    static int T;
    static int source, dest;

    static void fillPrime() {
        for (int i = 2; i < 10000; i++) {
            prime[i] = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0) {
                    prime[i] = false;
                    break;
                }
            }
        }
    }

    static int[] nums = new int[4];

    static Info bfs(int start) {
        Queue<Info> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new Info(start, 0));

        while (!queue.isEmpty()) {
            Info current = queue.poll();
            if(current.password == dest) {
                return current;
            }

            int num = current.password;


            for(int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++) {
                    if(i == 0 && j == 0) continue;
                    nums[0] = num / 1000;
                    nums[1] = num / 100 % 10;
                    nums[2] = num / 10 % 10;
                    nums[3] = num % 10;
                    nums[i] = j;
                    int changed = nums[0] * 1000 + nums[1] * 100 + nums[2] * 10 + nums[3];
                    if(visited[changed]) continue;
                    if(prime[changed] == false) continue;
                    visited[changed] = true;
                    queue.add(new Info(changed, current.count + 1));
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        prime = new boolean[10001];
        visited = new boolean[10001];
        fillPrime();
        for (int t = 0; t < T; t++) {
            String[] temp = br.readLine().split(" ");
            source = Integer.parseInt(temp[0]);
            dest = Integer.parseInt(temp[1]);

            Arrays.fill(visited, false);
            Arrays.fill(nums, 0);

            Info answer = bfs(source);
            if(answer == null) System.out.println("Impossible");
            else System.out.println(answer.count);
        }
    }
}

class Info {
    int password;
    int count;

    public Info(int password, int count) {
        this.password = password;
        this.count = count;
    }
}
