package com.driver;

public class Student {

    private String name;
    private int age;
    private double averageScore;

    public Student(){

    }

    public Student(String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public boolean compareTo(Student s2){
        if(this.getAge() != s2. getAge()) return false;
        if(!this.getName().equals(s2.getName())) return false;
        if(this.getAverageScore() != s2.getAverageScore()) return false;
        return true;
    }

}