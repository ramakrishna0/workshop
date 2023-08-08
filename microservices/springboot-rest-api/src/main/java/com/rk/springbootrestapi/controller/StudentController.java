package com.rk.springbootrestapi.controller;

import com.rk.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    // http://localhost:8080/student
    @GetMapping
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Rama", "Krishna");
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok()
                .header("custom-headers", "value 1", "value 2")
                .body(student);

    }

    // http://localhost:8080/student/getstudents
    @GetMapping("getstudents")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Rama", "Krishna"));
        students.add(new Student(1, "Rama", "Krishna"));
        students.add(new Student(1, "Rama", "Krishna"));
        students.add(new Student(1, "Rama", "Krishna"));
        return ResponseEntity.ok(students);
    }

    // http://localhost:8080/student/1/first-name/last-name
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // http://localhost:8080/student/query?id=1&firstName=Rama&lastName=Krishna
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // http://localhost:8080/student/create
    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // http://localhost:8080/student/4/update
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student);
        student.setId(id);
        System.out.println(student);
        return ResponseEntity.ok(student);
    }

    // http://localhost:8080/student/3/delete
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        System.out.println(id);
        return ResponseEntity.ok("Student deleted successfully");
    }


}
