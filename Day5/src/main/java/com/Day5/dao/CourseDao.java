package com.Day5.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Day5.entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

}
