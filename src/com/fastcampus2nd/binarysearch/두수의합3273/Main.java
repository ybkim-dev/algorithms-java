package com.fastcampus2nd.binarysearch.두수의합3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int x;
    static int[] arr;

    static int lowerBound(int target) {
        int left = 1; int right = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    static int upperBound(int target) {
        int left = 1; int right = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        String[] temp = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(temp[i - 1]);
        }
        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr, 1, n + 1);
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int target = x - arr[i];
            answer += (upperBound(target) - lowerBound(target));
        }
        System.out.println(answer / 2);
    }
}
