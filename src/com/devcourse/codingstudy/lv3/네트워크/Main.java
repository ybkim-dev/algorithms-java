package com.devcourse.codingstudy.lv3.네트워크;



public class Main {

    static boolean[] visited;

    static void dfs(int computerNum, int[][] computers) {
        visited[computerNum] = true;

        for(int y = 0; y < computers[computerNum].length; y++) {
            if(computers[computerNum][y] == 0) continue;
            if(visited[y]) continue;
            dfs(y, computers);
        }
    }


    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
}
