package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private int id;
    private String name;
    private double price;


    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }


}
