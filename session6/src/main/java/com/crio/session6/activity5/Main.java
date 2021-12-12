package com.crio.session6.activity5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
        String json = "{\"id\":1,\"name\":\"Jackson\",\"gender\":\"Male\"}";
        ObjectMapper mapper = new ObjectMapper();
        Student s = mapper.reader().forType(Student.class).readValue(json);
        System.out.println(s);
    }
}
