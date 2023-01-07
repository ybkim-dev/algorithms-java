package com.devcourse.codingstudy.lv2.가장긴팰린드롬;

public class Main {

    public int checkPalindromOddLength(String s, int index) {
        int cnt = 1;
        int left = index - 1;
        int right = index + 1;
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) break;
            cnt += 2;
            left -= 1; right += 1;
        }
        return cnt;
    }

    public int checkPalindromEvenLength(String s, int leftIndex, int rightIndex) {
        int cnt = 2;
        int left = leftIndex - 1;
        int right = rightIndex + 1;
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) break;
            cnt += 2;
            left -= 1; right += 1;
        }
        return cnt;
    }

    public int solution(String s)
    {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(checkPalindromOddLength(s, i), answer);
        }
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                answer = Math.max(checkPalindromEvenLength(s, i, i + 1), answer);
            }
        }
        return answer;
    }
}
