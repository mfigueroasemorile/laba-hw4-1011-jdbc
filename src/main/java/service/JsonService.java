package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Project;

import java.io.File;
import java.io.IOException;

public class JsonService {


    public <T> T parseJsonToObject(String jsonPath, Class<T> clazz){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(new File(jsonPath), clazz);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public <T> void convertObjectToJson(T object){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(object.getClass().getSimpleName() + ".json"), object);
            System.out.println("Object converted to json successfuly: ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
