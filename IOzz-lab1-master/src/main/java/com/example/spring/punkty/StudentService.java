package com.example.spring.punkty;


import io.vavr.collection.List;

public class StudentService {
    private List<Student> students = List.empty();

    List <Student> getStudents(){return this.students; }

    public Student addStudent(NewStudent newStudent) {
        students = students.append(new Student(
                students.size() + 1,
                newStudent.getName(),
                newStudent.getNumber(),
                newStudent.getGroup()
        ));
        Student created = new Student(students.size() + 1, newStudent.getName(), newStudent.getNumber(), newStudent.getGroup());
        students=students.prepend(created);
        return created;
    }

}
