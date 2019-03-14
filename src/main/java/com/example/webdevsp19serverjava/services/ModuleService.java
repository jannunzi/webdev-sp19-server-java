package com.example.webdevsp19serverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsp19serverjava.model.Course;
import com.example.webdevsp19serverjava.model.Module;
import com.example.webdevsp19serverjava.repositories.CourseRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ModuleService {
    @Autowired
    CourseRepository repo;
    
    @GetMapping("/api/courses/{courseId}/modules")
    public List<Module> findModulesForCourse(
            @PathVariable("courseId") Integer courseId) {
        Course course = repo.findById(courseId).get();
        return course.getModules();
    }
}
