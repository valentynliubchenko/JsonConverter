package org.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {
    private String name;
    private String secondname;
    private List<Integer> educ;
}
