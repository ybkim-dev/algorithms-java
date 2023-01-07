package com.devcourse.codingstudy.염색체9342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        String pattern = "([A-F]?[A]+[F]+[C]+[A-F]?)";
        while(T-- > 0) {
            String gene = br.readLine();
            boolean matches = Pattern.matches(pattern, gene);
            if(matches) System.out.println("Infected!");
            else System.out.println("Good");
        }
    }
}
