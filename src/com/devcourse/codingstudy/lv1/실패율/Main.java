package com.devcourse.codingstudy.lv1.실패율;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }
    public static int[] solution(int N, int[] stages) {

        int[] peopleInStageCount = new int[N + 2];
        int totalPeopleCount = stages.length;
        for (int i = 0; i < stages.length; i++) {
            peopleInStageCount[stages[i]]++;
        }

        List<Stage> arrayList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(totalPeopleCount ==0 ) arrayList.add(new Stage(i, 0));
            else arrayList.add(new Stage(i, (double) peopleInStageCount[i] / totalPeopleCount));
            totalPeopleCount -= peopleInStageCount[i];
        }

        Collections.sort(arrayList);
        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i).number;
        }

        return answer;
    }

    static class Stage implements Comparable<Stage> {
        int number;
        double rate;

        public Stage(int number, double rate) {
            this.number = number;
            this.rate = rate;
        }

        @Override
        public int compareTo(Stage other) {
            if(other.rate == this.rate) return this.number - other.number;
            // other가 더 크면 교체
            else if(this.rate < other.rate) return 1;
            // other가 더 작으면 유지
            else return -1;
        }
    }
}
