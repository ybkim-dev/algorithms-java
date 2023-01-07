package com.devcourse.codingstudy.lv2.순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}
        );
    }

    static public boolean isSame(Worker w1, Worker w2) {
        return w1.food.equals(w2.food) && w1.lang.equals(w2.lang) && w1.position.equals(w2.position)
                && w1.year.equals(w2.year);
    }

    static public int lowerBound(Worker target) {
        int left = 0;
        int right = workers.size() - 1;
        int result = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            // left = mid + 1;
            if((workers.get(mid).compareTo(target)) < 0) {
                left = mid + 1;
            }
            else {
                result = mid;
                right = mid - 1;
            }
        }
        return left;
    }

    static public int upperLimit(Worker target) {
        int left = 0;
        int right = workers.size() - 1;
        int result = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(workers.get(mid).comparing(target) <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    static List<Worker> workers = new ArrayList<>();

    static public int[] solution(String[] info, String[] query) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(String information : info) {
            String[] informationPiece = information.split(" ");
            workers.add(new Worker(informationPiece[0], informationPiece[1], informationPiece[2], informationPiece[3], Integer.parseInt(informationPiece[4])));
        }



        for(String queryString : query) {
            String[] queryPiece = queryString.split(" and ");
            String[] foodAndScore = queryPiece[3].split(" ");
            Worker target = new Worker(queryPiece[0], queryPiece[1], queryPiece[2], foodAndScore[0], Integer.parseInt(foodAndScore[1]));
            if(!target.lang.equals("-")) {
                Collections.sort(workers, Comparator.comparing(o -> o.lang));
            }
            if(!target.position.equals("-")) {
                Collections.sort(workers, Comparator.comparing(o -> o.position));
            }
            if(!target.year.equals("-")) {
                Collections.sort(workers, Comparator.comparing(o -> o.year));
            }
            if(!target.food.equals("-")) {
                Collections.sort(workers, Comparator.comparing(o -> o.food));
            }
            Collections.sort(workers, Comparator.comparingInt(o -> o.score));





            ans.add(upperLimit(target) - lowerBound(target));
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }



}

class Worker implements Comparable<Worker>{
    String lang;
    String position;
    String year;
    String food;
    int score;

    public Worker(String lang, String position, String year, String food, int score) {
        this.lang = lang;
        this.position = position;
        this.year = year;
        this.food = food;
        this.score = score;
    }


    @Override
    public int compareTo(Worker other) {
        if(!other.lang.equals("-")) {
            if(lang.compareTo(other.lang) != 0) return lang.compareTo(other.lang);
        }
        if (!other.position.equals("-")) {
            if(position.compareTo(other.position) != 0) return position.compareTo(other.position);
        }
        if(!other.year.equals("-")) {
            if(year.compareTo(other.year) != 0) return year.compareTo(other.year);
        }
        if(!other.food.equals("-")) {
            if(food.compareTo(other.food) != 0) return food.compareTo(other.food);
        }
        return score - other.score;
    }

    public int comparing(Worker other) {
        if(!other.lang.equals("-")) {
            if(lang.compareTo(other.lang) != 0) return lang.compareTo(other.lang);
        }
        if (!other.position.equals("-")) {
            if(position.compareTo(other.position) != 0) return position.compareTo(other.position);
        }
        if(!other.year.equals("-")) {
            if(year.compareTo(other.year) != 0) return year.compareTo(other.year);
        }
        if(!other.food.equals("-")) {
            if(food.compareTo(other.food) != 0) return food.compareTo(other.food);
        }
        return 0;
    }
}
