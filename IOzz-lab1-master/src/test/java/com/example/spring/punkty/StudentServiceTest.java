package com.example.spring.punkty;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class StudentServiceTest {

    @Test
    public void getEmptyList(){
        final StudentService service = new StudentService();
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    public void addStudent(){
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Tymoteusz","1-2-3","IP"));
        assertNotNull(created);
    }

    @Test
    public void addStudentReturned(){
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Mateusz","1-2-3","IP"));
        final List<Student> all = service.getStudents();
        assertEquals(created.name, all.head().name);
    }

    @Test
    public void addStudentHasNewId(){
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Mateusz","1-2-3","IP"));
        final Student created1 = service.addStudent(new NewStudent("Tymoteusz","1-2-3","IP"));
        assertEquals(4,service.getStudents().size());
        assertNotEquals(created,created1);
    }



}