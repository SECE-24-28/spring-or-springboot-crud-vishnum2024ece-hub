package com.example.studenthub.component;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    public Course getCourse() {
        return new Course(1,"tamil");
    }
}