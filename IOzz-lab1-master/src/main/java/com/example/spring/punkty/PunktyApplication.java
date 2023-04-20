package com.example.spring.punkty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "punkty/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@SpringBootApplication
public class PunktyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PunktyApplication.class, args);
	}

    private final StudentService service=new StudentService();

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getUsers() {
        return this.service.getStudents().asJava();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addStudent(@RequestBody NewStudent newStudent) {
        return this.service.addStudent(newStudent);
    }


    @GetMapping("/hello")
    public String hello() {
        LocalDateTime now = LocalDateTime.now();
        return "Hello! Aktualny czas: " + now;
    }
}


