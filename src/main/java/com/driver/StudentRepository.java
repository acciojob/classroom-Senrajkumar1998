package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> Students ;
    private List<Teacher> Teachers ;
    private HashMap<String,List<Student>> Pair;

    public StudentRepository() {
        this.Students = new ArrayList<>();
        this.Teachers = new ArrayList<>();
        this.Pair = new HashMap<>();
    }

    public void addStudent(Student student){
        Students.add(student);
    }
    public void addTeacher(Teacher teacher){
        Teachers.add(teacher);

    }
    public void addStudentTeacherPair(String studentName,String teacherName) {

        for (Student student : Students) {
            if (student.getName().equals(studentName)) {
                if (Pair.containsKey(teacherName)) {
                    Pair.get(teacherName).add(student);
                }
                else{
                    List<Student> newList = new ArrayList<>();
                    newList.add(student);
                    Pair.put(teacherName,newList);
                }
            }

        }
        for(Teacher teacher:Teachers){
            if(teacher.getName().equals(teacherName)) {
                teacher.setNumberOfStudents(Pair.get(teacherName).size());
                break;
            }
        }

    }
    public Student getStudentByName(String studentName){
        for(Student student:Students){
            if(studentName.equals(student.getName())) return student;
        }
        return null;
    }
    public Teacher getTeacherByName(String teacherName){
        for(Teacher teacher:Teachers){
            if(teacher.getName().equals(teacherName)) return teacher;
        }
        return null;
    }
    public List<String> getStudentByTeacherName(String teacherName){
        if(!Pair.containsKey(teacherName)) return null;
        List<String> names = new ArrayList<>();
        for(Student student : Pair.get(teacherName)){
            names.add(student.getName());
        }
        return names;
    }
    public List<String> getAllStudents(){
        if(Students.isEmpty()) return null;
        List<String> names = new ArrayList<>();
        for(Student student : Students){
            names.add(student.getName());
        }
        return names;
    }
    public void deleteTeacherByName(String teacherName){
        for(Student student : Pair.get(teacherName)){
            Students.remove(student);
        }
        Pair.remove(teacherName);

    }
    public void deleteAllTeachers(){
        for(String pair : Pair.keySet()){
            for(Student student:Pair.get(pair)){
                Students.remove(student);
            }
            Pair.remove(pair);
        }

    }
}