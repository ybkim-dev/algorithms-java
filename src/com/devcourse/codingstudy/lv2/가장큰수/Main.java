package com.devcourse.codingstudy.lv2.가장큰수;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> nums;

    public static void main(String[] args) {
        solution(new int[]{1, 11, 110, 1110});
    }

    static public String solution(int[] numbers) {
        nums = new ArrayList<>();
        for(int num : numbers) {
            nums.add(num);
        }

        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return -(Integer.parseInt(s1 + s2) - Integer.parseInt(s2 + s1));
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int num : nums) {
            sb.append(num);
        }
        String answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}
