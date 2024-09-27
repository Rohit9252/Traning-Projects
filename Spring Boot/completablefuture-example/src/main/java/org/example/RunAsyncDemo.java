package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Employee;

import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
public class RunAsyncDemo {


    public Void saveEmployee(File JsonFile) throws ExecutionException, InterruptedException {


        ObjectMapper mapper = new ObjectMapper();
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Employee> employeeList = mapper.
                            readValue(JsonFile, new TypeReference<List<Employee>>() {
                            });
                    System.out.println("Thread Name: " + Thread.currentThread().getName());
                    employeeList.stream().forEach(System.out::println);
                    // logic for saving data to database
                    // using repository.saveAll(employeeList);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }
        });

        // if this is blocking the thread we can use
       // runAsyncFuture.toCompletableFuture();
        return runAsyncFuture.get();



    }

    // using java8
    public Void saveEmployeeUsingLambda(File JsonFile) throws ExecutionException, InterruptedException {


        ObjectMapper mapper = new ObjectMapper();
        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(()-> {
                try {
                    List<Employee> employeeList = mapper.
                            readValue(JsonFile, new TypeReference<List<Employee>>() {
                            });
                    System.out.println("Thread Name: " + Thread.currentThread().getName());
//                    employeeList.stream().forEach(System.out::println);
                    System.out.println("Employee List Size : " + employeeList.size());
                    // logic for saving data to database
                    // using repository.saveAll(employeeList);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

        }, executor);


        return runAsyncFuture.get();



    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        RunAsyncDemo runAsyncDemo = new RunAsyncDemo();

        runAsyncDemo.saveEmployeeUsingLambda(new File("employee.json"));


    }



}
