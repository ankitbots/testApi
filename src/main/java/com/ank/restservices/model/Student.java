package com.ank.restservices.model;

import lombok.Data;

import java.util.List;

/**
 * Created by AnkitNigam on 6/27/2018.
 */
@Data
public class Student {
    private String id;
    private String name;
    private String description;
    private List<Course> courses;

    public Student(String id, String name, String description, List<Course> courses) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.courses = courses;
    }
}
