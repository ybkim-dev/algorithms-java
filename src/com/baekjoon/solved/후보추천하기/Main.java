package com.baekjoon.solved.후보추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static int N;
    static int K;
    static Nominee[] nominees;
    static ArrayList<Nominee> pictures;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        nominees = new Nominee[101];
        pictures = new ArrayList<>();

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < temp.length; i++) {
            int num = Integer.parseInt(temp[i]);

            // 최초 등록
            if(nominees[num] == null) {
                nominees[num] = new Nominee(num, 0, 0, false);
            }
            if(nominees[num].isIn == true) {
                nominees[num].recommendationCnt++;
            } else {
                if(pictures.size() == N) {
                    Collections.sort(pictures, new Comparator<Nominee>() {
                        @Override
                        public int compare(Nominee o1, Nominee o2) {
                            if(o1.recommendationCnt == o2.recommendationCnt) return o2.age - o1.age;
                            return o2.recommendationCnt - o1.recommendationCnt;
                        }
                    });
                    Nominee nominee = pictures.remove(pictures.size() - 1);
                    nominee.isIn = false;
                }
                nominees[num].age = i;
                nominees[num].isIn = true;
                nominees[num].recommendationCnt = 1;
                pictures.add(nominees[num]);

            }
        }

        Collections.sort(pictures, new Comparator<Nominee>() {
            @Override
            public int compare(Nominee o1, Nominee o2) {
                return o1.num - o2.num;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Nominee nominee : pictures) {
            sb.append(nominee.num).append(" ");
        }


        System.out.println(sb.toString());
    }
}

class Nominee {
    int num;
    int age;
    int recommendationCnt;
    boolean isIn;

    public Nominee(int num, int age, int recommendationCnt, boolean isIn) {
        this.num = num;
        this.age = age;
        this.recommendationCnt = recommendationCnt;
        this.isIn = isIn;
    }
}
