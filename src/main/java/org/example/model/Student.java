package org.example.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    String name;
    String secondname;
    List<Integer> educ;
}
