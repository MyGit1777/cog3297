package com.Day5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Day5.entity.Course;
import com.Day5.service.CourseImpl;

@RestController
@CrossOrigin("*")
public class Controller {

	@Autowired
	private CourseImpl courseImpl;
	
	@GetMapping("/course")
	public List<Course> getAllCourses() {
		return this.courseImpl.getCourse();

	}

	@PostMapping("/course/create")
	public Course addNewCourse(@RequestBody Course course) {
		return this.courseImpl.addCourse(course);

	}

	@PutMapping("/course/update/{courseId}")
	public Course updateExistingCourse(@RequestBody Course course) {

		return this.courseImpl.updateCourse(course);

	}
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/course/delete/{courseId}")
	public ResponseEntity<HttpStatus> deleteExistingCourse(@PathVariable Integer courseId) {

		try {
			this.courseImpl.deleteCourse(courseId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
