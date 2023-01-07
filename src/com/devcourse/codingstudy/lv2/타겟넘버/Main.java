package com.devcourse.codingstudy.lv2.타겟넘버;

public class Main {

    static int cnt;

    public void dfs(int index, int target, int result, int[] numbers) {
        if (index == numbers.length) {
            if(result == target) cnt++;
        } else {
            dfs(index + 1, target, result + numbers[index], numbers);
            dfs(index + 1, target, result - numbers[index], numbers);

        }
    }


    public int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(0, target, 0, numbers);
        answer = cnt;

        return answer;
    }
}

