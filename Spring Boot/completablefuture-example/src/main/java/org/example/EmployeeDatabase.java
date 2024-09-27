package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeDatabase {


    public static List<Employee> fetchEmployeeData() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        try{
            return mapper.
                    readValue(new File("employee.json"), new TypeReference<List<Employee>>() {
                    });
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        return  null;




    }



}
