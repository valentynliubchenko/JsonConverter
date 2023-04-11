package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.example.model.Student;

import java.io.IOException;
import java.nio.charset.Charset;

public class App {
    public static void main (String[] args) {
        //1 json from file
        Student student = null;
        try {
            student = getStudent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //2 output Json
        System.out.println(student);
        try {
            String jsonStr = new ObjectMapper().writeValueAsString(student);
            System.out.println(jsonStr);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        //3 String json to Object
        String jsonKola = "{\"name\":\"Kolja\",\"secondname\":\"KOlesnik\",\"educ\":[38,75,53]}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student kola = mapper.readValue(jsonKola, Student.class);
            System.out.println(kola);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Can not deserialize solvitCase", e);
        }

    }

    private static Student getStudent () throws IOException {
        String object = IOUtils.resourceToString("/data/student.json", Charset.defaultCharset());
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(object, Student.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Can not deserialize solvitCase", e);
        }
    }
}
