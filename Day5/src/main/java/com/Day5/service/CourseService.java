package com.Day5.service;

import java.util.List;

import com.Day5.entity.Course;

public interface CourseService {

	public List<Course> getCourse();

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(Integer id);

}
