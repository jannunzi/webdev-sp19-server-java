package com.example.webdevsp19serverjava.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevsp19serverjava.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
