package com.example.studenthub.controller;

import com.example.studenthub.component.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>();


    // CREATE
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {

        students.add(student);

        return "Student Added";
    }


    // READ
    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }


    // UPDATE
    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id,
                                @RequestBody Student newStudent) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(newStudent.getName());
                student.setDepartment(newStudent.getDepartment());

                return "Student Updated";
            }
        }

        return "Student Not Found";
    }


    // DELETE
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                students.remove(student);

                return "Student Deleted";
            }
        }

        return "Student Not Found";
    }
}