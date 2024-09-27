package com.test.controller;


import com.test.model.Data;
import com.test.model.Entry;
import com.test.model.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/entries/{category}")
    public ResponseEntity<Object> getEntriesByCategoriesHandler(@PathVariable("category") String category){

        String url = "https://api.publicapis.org/entries";

        Data data = restTemplate.getForObject(url, Data.class);

        List<Entry> list = data.getEntries();



        List<ResponseDto> result= list.stream()
                .filter(e -> e.getCategory()
                        .equals(category))
                        .map(e -> new ResponseDto(e.getApi(), e.getDescription()))
                        .toList();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    //  Create an API that would save a new entry with all the relevant properties which retrieves values from the endpoint GET /entries.


    @GetMapping("/entries")
    public ResponseEntity<Object> getEntriesByCategoriesHandler(@RequestBody Entry entry){

        String url = "https://api.publicapis.org/entries";

        Data data = restTemplate.getForObject(url, Data.class);

        List<Entry> list = data.getEntries();

        list.add(entry);


        return new ResponseEntity<Object>(list,HttpStatus.ACCEPTED);

    }




}
