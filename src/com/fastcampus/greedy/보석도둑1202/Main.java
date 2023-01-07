package com.fastcampus.greedy.보석도둑1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int K;
    static ArrayList<Integer> bags;
    static ArrayList<Jewelry> jewelries;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        bags = new ArrayList<>();
        jewelries = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            jewelries.add(new Jewelry(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        // 가방 정렬
        Collections.sort(bags);
        // 보석 무게 순 정렬
        Collections.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                return o1.weight - o2.weight;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        int jewerlyPointer = 0;
        for (int i = 0; i < bags.size(); i++) {
            // 가방 크기 보다 작은 보석들은 전부 PQ 에 넣기
            while(jewerlyPointer < N && jewelries.get(jewerlyPointer).weight <= bags.get(i)) {
                pq.add(jewelries.get(jewerlyPointer).value);
                jewerlyPointer++;
            }

            if (!pq.isEmpty()) {
                Integer inBagJewelry = pq.poll();
                sum += inBagJewelry;
            }
        }

        System.out.println(sum);
    }

}

class Jewelry {
    int weight;
    int value;

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
