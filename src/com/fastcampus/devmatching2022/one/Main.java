package com.fastcampus.devmatching2022.one;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"bird99","bird98","bird101","gotoxy"},
                "bird98"));
    }

    static public String solution(String[] registered_list, String new_id) {
        String answer = "";

        Arrays.sort(registered_list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });
        boolean finish = false;
        int searchIndex = 0;
        while(true) {

            boolean find = false;
            for (int j = searchIndex; j < registered_list.length; j++) {
                String registeredId = registered_list[j];
                if (registeredId.equals(new_id)) {
                    // 포함되어 있으면
                    searchIndex = j;
                    int numberStart = 0;
                    for (int i = 3; i < new_id.length(); i++) {
                        if(Character.isDigit(new_id.charAt(i))) {
                            numberStart = i;
                            break;
                        }
                    }
                    int N = 0;
                    if(numberStart > 0) {
                        N = Integer.parseInt(new_id.substring(numberStart));
                    }

                    N += 1;
                    if(numberStart ==0 ) {
                        new_id = new_id + String.valueOf(N);
                    } else {
                        new_id = new_id.substring(0, numberStart) + String.valueOf(N);
                    }
                    find = true;
                    break;
                }
            }
            if(!find) {
                answer = new_id;
                finish = true;
                break;
            }
            if(finish) {
                break;
            }
        }

        return answer;
    }
}
