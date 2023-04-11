package org.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Student {
    String name;
    String secondname;
    List<Integer> educ;
}
