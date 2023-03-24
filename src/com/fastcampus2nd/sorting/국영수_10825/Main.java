package com.fastcampus2nd.sorting.국영수_10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  static int N;
  static ArrayList<Student> students = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String[] temp = br.readLine().split(" ");
      students.add(new Student(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]),
          Integer.parseInt(temp[3])));
    }
    Collections.sort(students);
    for (int i = 0; i < students.size(); i++) {
      System.out.println(students.get(i).name);
    }
  }

  static class Student implements Comparable<Student> {
    String name;
    int kor;
    int eng;
    int math;

    @Override
    public int compareTo(Student o) {
      if(this.kor != o.kor) return o.kor - this.kor;
      if(this.eng != o.eng) return this.eng - o.eng;
      if(this.math != o.math) return o.math - this.math;
      return this.name.compareTo(o.name);
    }

    public Student(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
    }
  }


}
