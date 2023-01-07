package com.fastcampus.greedy;

import java.util.Arrays;
import java.util.Comparator;

// Greedy Algorithm 예제로 쓰임
public class FractionKnapsackProblem {
    // 2차원 배열로 작성해보기
    static int[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};

    static public void knapsackFunc(int[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;
        int totalWeight = 0;


        Arrays.sort(objectList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if ((double)(o1[1] / o1[0]) - (double)(o2[1] - o2[0]) <0 ) {
                    return -1;
                } else if ((double)(o1[1] / o1[0]) - (double)(o2[1] - o2[0]) == 0 ) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < objectList.length; i++) {
            if((capacity - (double)objectList[i][0]) >= 0) {
                // 다 넣을 수 있음.
                totalValue += objectList[i][1];
                capacity -= objectList[i][0];
                totalWeight += objectList[i][0];
                System.out.println("무게 : " + objectList[i][0] + ", 가치 : " + objectList[i][1] );
            } else {
                // 조각 내서 넣어야함
                fraction = (double) (capacity / objectList[i][0]);
                totalValue += (double) (objectList[i][1] * fraction);
                totalWeight += objectList[i][0] * fraction;
                System.out.println("무게 : " + objectList[i][0] + ", 가치 : " + objectList[i][1] + ", 추가된 비율 : " + fraction);
                break;
            }
        }
        System.out.println("totalValue = " + totalValue);
        System.out.println("totalWeight = " + totalWeight);
    }

    public static void main(String[] args) {
        knapsackFunc(objectList, 30);
    }
}
