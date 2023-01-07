package com.devcourse.codingstudy.효율적인해킹1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] check;
    static boolean[] visited;
    static int ans;
    static int globalAns = -1;

    static void dfs(int start) {
        visited[start] = true;
        ans++;

        for(int x : adj[start]) {
            if(!visited[x]) {
                dfs(x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        visited = new boolean[N + 1];
        check = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");
            int src = Integer.parseInt(temp[1]);
            int dest = Integer.parseInt(temp[0]);
            adj[src].add(dest);
            check[dest] = true;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(!check[i] && adj[i].size() > 0) {
                Arrays.fill(visited, false);
                ans = 0;
                dfs(i);
                if(globalAns < ans) {
                    arr.clear();
                    arr.add(i);
                    globalAns = ans;
                } else if(globalAns == ans) {
                    arr.add(i);
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }

    }
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main
//{
//    static int N;
//    static int M;
//
//    static List<Integer>[] list;
//
//    static int[] visited = new int[10001];
//    static int[] ans = new int[10001];
//
//    public static void main(String[] args) throws Exception
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String input = br.readLine();
//
//        StringTokenizer st = new StringTokenizer(input);
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        visited = new int[N+1];
//        ans = new int[N+1];
//
//        list = new ArrayList[N + 1];
//        for (int i = 1; i <= N; i++)
//        {
//            list[i] = new ArrayList<Integer>();
//        }
//
//        String[] inputs = new String[2];
//        for (int i = 1; i <= M; i++)
//        {
//            input = br.readLine();
//            inputs = input.split(" ");
//            list[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
//        }
//
//        // DFS
//		for (int i = 1; i <= N; i++)
//		{
//			visited = new int[N+1];
//			visited[i] = 1;
//			dfs(i);
//		}
//
//
//        // answer
//        int max = 0;
//        for (int i = 1; i <= N; i++)
//        {
//            max = Math.max(max, ans[i]);
//        }
//
//        StringBuffer sb = new StringBuffer();
//        for (int i = 1; i <= N; i++)
//        {
//            if (max == ans[i])
//                sb.append(i + " ");
//        }
//
//        System.out.println(sb.toString().trim());
//
//        // 컴퓨터당 해킹최대개수
////		System.out.println(Arrays.toString(ans));
//    }
//
//    private static void dfs(int node)
//    {
//        for (int next : list[node])
//        {
//            if (visited[next] == 0)
//            {
////				System.out.println(node + " -> " + next);
//                ans[next]++;
//                visited[next] = 1;
//                dfs(next);
//            }
//        }
//    }
//}