package com.devcourse.codingstudy.무지의먹방라이브;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Food> foods = new PriorityQueue<>(new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.num - o2.num;
        }
    });
    public int solution(int[] food_times, long k) {
        int sum = 0;
        for(int i = 0; i < food_times.length; i++) {
            sum += food_times[i];
        }
        if(sum > k) return -1;

        int answer = 0;

        for(int i = 0; i < food_times.length; i++) {
            if(food_times[i] == 0) continue;
            foods.add(new Food(i + 1, food_times[i]));
        }


        int currEat = 0;



        return answer;
    }
}

class Food {
    int num;
    int quantity;

    public Food(int num, int quantity) {
        this.num = num;
        this.quantity = quantity;
    }
}