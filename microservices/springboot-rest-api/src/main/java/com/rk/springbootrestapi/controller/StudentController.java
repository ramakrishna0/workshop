package com.rk.springbootrestapi.controller;

import com.rk.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Rama", "Krishna");
    }

    // http://localhost:8080/student
    @GetMapping("/getstudents")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Rama", "Krishna"));
        students.add(new Student(1, "Rama", "Krishna"));
        students.add(new Student(1, "Rama", "Krishna"));
        students.add(new Student(1, "Rama", "Krishna"));
        return students;
    }

    // http://localhost:8080/student/1/"first-name"/"last-name"
    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable int id,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(id, firstName, lastName);
    }

    // http://localhost:8080/student/query?id=1&firstName=Rama&lastName=Krishna
    @GetMapping("student/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    // http://localhost:8080/student/create
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student);
        return student;
    }

    // http://localhost:8080/student/4/update
    @PutMapping("student/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student);
        student.setId(id);
        System.out.println(student);
        return student;
    }

    // http://localhost:8080/student/3/delete
    @DeleteMapping("student/{id}/delete")
    public String deleteStudent(@PathVariable int id) {
        System.out.println(id);
        return "Student deleted successfully";
    }


}
