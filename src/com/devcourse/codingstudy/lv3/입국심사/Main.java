package com.devcourse.codingstudy.lv3.입국심사;

import java.util.Arrays;

public class Main {
    static public long binarySearch(long left, long right, int[] times, int n) {
        long ans = -1;
        while(left <= right) {
            long mid = (left + right) / 2;
            if(countDone(mid, times) < n) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    static public long countDone(long k, int[] times) {
        long count = 0;
        for (int i = 0; i < times.length; i++) {
            count += (k / times[i]);
        }
        return count;
    }

    static public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = binarySearch(0L, (long) times[times.length - 1] * (long) n, times, n);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }
}
