package com.learn.interview;

public class Student {

    private String name;
    private String address;
    private Subject marks;

    public Student(String name, String address, Subject subject) {
        this.name = name;
        this.address = address;
        this.marks = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Subject getMarks() {
        return marks;
    }

    public void setMarks(Subject marks) {
        this.marks = marks;
    }
}
