package com.example.webdevsp19serverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsp19serverjava.model.Course;
import com.example.webdevsp19serverjava.repositories.CourseRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
//,
//    allowCredentials="true",
//    methods = {RequestMethod.POST, RequestMethod.GET})
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    
    
    @DeleteMapping("/api/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Integer id) {
        // LTR
    }
    @PutMapping("/api/courses/{courseId}")
    public Course updateCourse(
            @PathVariable("courseId") Integer id,
            @RequestBody Course newCourse) {
        return null;
    }
    @PostMapping("/api/courses")
    public Course createCourse(
            @RequestBody Course course) {
        return course;
    }
    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return (List<Course>) this.courseRepository.findAll();
    }
    @GetMapping("/api/courses/{userId}")
    public Course findCourseById(
            @PathVariable("userId") Integer id) {
        return null;
    }
}
