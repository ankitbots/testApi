package com.ank.restservices.model;

import lombok.Data;

import java.util.List;

/**
 * Created by AnkitNigam on 6/27/2018.
 */
@Data
public class Course {
    private String id;
    private String name;
    private String description;
    private List<String> steps;

    public Course(String id, String name, String description, List<String> steps) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.steps = steps;
    }

}
