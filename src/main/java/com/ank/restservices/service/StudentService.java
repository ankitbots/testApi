package com.ank.restservices.service;

import com.ank.restservices.model.Course;
import com.ank.restservices.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AnkitNigam on 6/27/2018.
 */
@Component
public class StudentService {
    private static List<Student> students = new ArrayList<>();
    static {
        Course course1 = new Course("Course1","Spring", "10 Steps", Arrays.asList("Learn mvn","Import project", "First Example", "Second Example"));
        Course course2 = new Course("Course2","Spring MVC" , "10 More Steps", Arrays.asList("Learn mvn","Import project", "First Example", "Second Example"));
        Course course3 = new Course("Course3","Spring Boot" , "10 More More Steps", Arrays.asList("Learn mvn","Learn Spring",
                "Import project", "First Example", "Second Example"));
        Course course4 = new Course("Course","Spring Boot API" , "10 More API Steps", Arrays.asList("Learn mvn","Learn Spring","Learn SpringBoot",
                "Import project", "First Example", "Second Example"));

        Student ankit = new Student("Student1", "Ankit Nigam", "Tester/Evangelist",  new ArrayList<>(Arrays.asList(course1,course2)));
        Student ashish = new Student("Student2", "Ashish Nigam", "Tester/KPO",  new ArrayList<>(Arrays.asList(course2,course3, course4)));

        students.add(ankit);
        students.add(ashish);
    }

    public List<Student> retriveAllStudents() {
        return students;
    }
    public Student retriveStudent(String studentId){
        return students.stream().
                filter(student -> studentId.equals(student.getId())).findFirst().orElse(null);
    }

    public List<Course> retriveCourses(String studentId){
        Student student = retriveStudent(studentId);
        if (student==null){
            return null;
        }
        return student.getCourses();
    }

    public Course retriveCourse(String studentId, String courseId){
        Student student = retriveStudent(studentId);
        if (student==null) return null;
        return student.getCourses().stream().
                filter(course -> courseId.equalsIgnoreCase(course.getId())).
                findFirst().orElse(null);
    }

    private SecureRandom random = new SecureRandom();

    public Course addCourse(String studentId, Course course){
        Student student = retriveStudent(studentId);
        if (student==null){
            return null;
        }

        String randomId = new BigInteger(130, random).toString(30);
        course.setId(randomId);
        student.getCourses().add(course);
        return course;
    }

}
