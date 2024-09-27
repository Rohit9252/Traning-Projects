package org.example;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.dto.Employee;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
public class SupplyAsyncDemo {

    @SneakyThrows
    public List<Employee> getEmployeeData() throws ExecutionException, InterruptedException , IOException {
        CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture.supplyAsync(()->{

            try {
                System.out.println("Executed by: " + Thread.currentThread().getName());
                return EmployeeDatabase.fetchEmployeeData();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return listCompletableFuture.join();

    }

    @SneakyThrows
    public List<Employee> getEmployeeDataUsingExecutor() throws ExecutionException, InterruptedException , IOException {

        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture.supplyAsync(()->{

            try {
                System.out.println("Executed by: " + Thread.currentThread().getName());
                return EmployeeDatabase.fetchEmployeeData();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, executor);

        return listCompletableFuture.join();

    }


    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        SupplyAsyncDemo supplyAsyncDemo = new SupplyAsyncDemo();

        List<Employee> employeeData = supplyAsyncDemo.getEmployeeData();
        employeeData.stream().forEach(System.out::println);

        supplyAsyncDemo.getEmployeeDataUsingExecutor().stream().forEach(System.out::println);


    }





}
