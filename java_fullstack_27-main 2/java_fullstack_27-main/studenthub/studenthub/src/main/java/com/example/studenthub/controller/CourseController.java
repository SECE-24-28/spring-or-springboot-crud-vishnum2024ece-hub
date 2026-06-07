package com.example.studenthub.controller;

import com.example.studenthub.component.Course;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    List<Course> courses = new ArrayList<>();


    // CREATE
    @PostMapping("/courses")
    public String addCourse(@RequestBody Course course) {

        courses.add(course);

        return "Course Added";
    }


    // READ
    @GetMapping("/courses")
    public List<Course> getCourses() {

        return courses;
    }


    // UPDATE
    @PutMapping("/courses/{id}")
    public String updateCourse(@PathVariable int id,
                               @RequestBody Course newCourse) {

        for (Course course : courses) {

            if (course.getId() == id) {

                course.setCourse(newCourse.getCourse());

                return "Course Updated";
            }
        }

        return "Course Not Found";
    }


    // DELETE
    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id) {

        for (Course course : courses) {

            if (course.getId() == id) {

                courses.remove(course);

                return "Course Deleted";
            }
        }

        return "Course Not Found";
    }
}