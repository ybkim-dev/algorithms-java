package com.fastcampus2nd.greedy.보석도둑_1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
  static int N, K;
  static Jewelry[] jewelries;
  static int[] bags;
  static PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
  static long ans;

  static void solve() {
    // 작은 가방부터 차례로 해당 가방에 넣을 수 있는 최대 가치 보석 찾기
    Arrays.sort(bags);
    Arrays.sort(jewelries, (o1,o2) -> o1.weight - o2.weight);

    int jewelryPointer = 0;
    // 작은 가방부터 차례로 넣을 수 있는 보석 크기 고려해 Pq 넣기
    for (int i = 0; i < bags.length; i++) {
      while(jewelryPointer < N && jewelries[jewelryPointer].weight <= bags[i]) {
        pq.add(jewelries[jewelryPointer]);
        jewelryPointer++;
      }
      if(!pq.isEmpty()) {
        Jewelry curr = pq.poll();
        ans += curr.value;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    N = Integer.parseInt(temp[0]);
    K = Integer.parseInt(temp[1]);

    jewelries = new Jewelry[N];
    bags = new int[K];

    for (int i = 0; i < N; i++) {
      temp = br.readLine().split(" ");
      jewelries[i] = new Jewelry(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
    }

    for (int i = 0; i < K; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }

    solve();

    System.out.println(ans);

  }

  static class Jewelry {
    int weight;
    int value;

    public Jewelry(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }
  }
}
