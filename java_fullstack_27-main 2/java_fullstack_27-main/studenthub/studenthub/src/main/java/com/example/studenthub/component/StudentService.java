package com.example.studenthub.component;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student getStudent() {
        return new Student(1, "Ram", "CSE");
    }
}