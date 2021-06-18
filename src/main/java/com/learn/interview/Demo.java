package com.learn.interview;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        Subject subject = new Subject(23, 45);
        Subject subject1 = new Subject(32, 48);
        Subject subject2 = new Subject(56, 45);

        Student student = new Student("Akash", "Bangalore", subject);
        Student student1 = new Student("Sudesh", "KRPuram", subject1);
        Student student2 = new Student("Giri", "Ahmedabad", subject2);

        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);



    }


}
