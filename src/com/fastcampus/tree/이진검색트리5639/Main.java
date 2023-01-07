package com.fastcampus.tree.이진검색트리5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static void postOrder(int l, int r) {
        if(l > r) return;
        int mid = r;
        for(int i = l + 1; i <= r; i++){
            if(arr.get(i) > arr.get(l)) {
                mid = i - 1;
                break;
            }
        }

        // post order
        postOrder(l + 1, mid);
        postOrder(mid + 1, r);
        sb.append(arr.get(l)).append("\n");
    }

    public static void main(String[] args) throws IOException {
        String input = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while((input = br.readLine()) != null) {
                arr.add(Integer.parseInt(input));
            }
        } catch(Exception e) {

        }


        postOrder(0, arr.size() - 1);
        System.out.println(sb.toString());
    }
}
