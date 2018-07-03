package com.ank.restservices.controller;

import com.ank.restservices.model.Course;
import com.ank.restservices.model.Student;
import com.ank.restservices.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by AnkitNigam on 6/27/2018.
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{studentId}/courses")
    public List<Course> retriveCoursesForStudent(@PathVariable String studentId){
        return studentService.retriveCourses(studentId);
    }

    @GetMapping("/students/{studentId}/courses/{courseId}")
    public Course retiveDetailsForCourse(@PathVariable String studentId, @PathVariable String courseId){
        return studentService.retriveCourse(studentId, courseId);
    }

    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<Void> registerStudentForCourse(@PathVariable String studentId, @RequestBody Course newCourse){
        Course course = studentService.addCourse(studentId, newCourse);

        if(course == null){
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/students")
    public List<Student> retiveAllStudents(){
        return studentService.retriveAllStudents();
    }
}
