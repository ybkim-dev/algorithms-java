package com.fastcampus2nd.binarysearch.듣보잡1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static String[] listen;
    static String[] see;

    static boolean binarySearch(String[] see, int L, int R, String target) {
        boolean result = false;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(see[mid].compareTo(target) < 0) {
                L = mid + 1;
            } else if(see[mid].compareTo(target) > 0) {
                R = mid - 1;
            } else {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        listen = new String[N + 1];
        see = new String[M + 1];
        for (int i = 1; i <= N; i++) {
            listen[i] = br.readLine();
        }
        for (int i = 1; i <= M; i++) {
            see[i] = br.readLine();
        }
        Arrays.sort(listen, 1, N + 1);
        Arrays.sort(see, 1, M + 1);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            boolean result = binarySearch(see, 1, M, listen[i]);
            if(result) {
                sb.append(listen[i]).append("\n");
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
