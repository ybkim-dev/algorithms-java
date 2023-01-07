package com.fastcampus2nd.sorting.파일정리20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int N;
    static String[] extensions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        extensions = new String[N];
        for (int i = 0; i < N; i++) {
            extensions[i] = br.readLine().split("\\.")[1];
        }

        Arrays.sort(extensions, (o1, o2) -> o1.compareTo(o2));

        int curCnt = 1;
        String curExtension = extensions[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            if (curExtension.equals(extensions[i])) {
                curCnt++;
            }
            else {
                sb.append(curExtension).append(" ").append(curCnt).append("\n");
                curCnt = 1;
            }
            curExtension = extensions[i];
        }
        sb.append(curExtension).append(" ").append(curCnt);
        System.out.println(sb);
    }
}
