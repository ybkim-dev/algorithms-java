package com.fastcampus.sorting.국영수10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<Student> students = new ArrayList<>();

    static void solve() {
        Collections.sort(students);
        students.forEach((student) -> System.out.println(student.name));
    }

    static class Student implements Comparable<Student>{
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(kor != o.kor) return o.kor - kor;
            if(eng != o.eng) return eng - o.eng;
            if(math != o.math) return o.math - math;
            return name.compareTo(o.name);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            students.add(new Student(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3])));
        }

        solve();
    }
}
