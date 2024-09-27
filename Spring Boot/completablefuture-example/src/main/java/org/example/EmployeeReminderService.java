package org.example;

import org.example.dto.Employee;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class EmployeeReminderService {



    public CompletableFuture<Void> sendReminderToEmployee()  {
        // logic for sending reminder to employee

        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Executed Thread Name: " + Thread.currentThread().getName());
                TimeUnit.MINUTES.sleep(1);
                return EmployeeDatabase.fetchEmployeeData();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        },executor).thenApplyAsync((employees) -> {
            System.out.println("Filter New Joiner Employee: " + Thread.currentThread().getName());
            return employees
                    .stream()
                    .filter(employee -> "TRUE".equals(employee.getNewJoiner()))
                    .collect(Collectors.toList());
        },executor).thenApplyAsync((employees) -> {
            System.out.println("Filter Employee who has not completed their training: " + Thread.currentThread().getName());
            return employees
                    .stream()
                    .filter(employee -> "FALSE".equals(employee.getLearningPending()))
                    .collect(Collectors.toList());
        }, executor).thenApplyAsync((employees) -> {
            System.out.println("Filter Employee Email Id: " + Thread.currentThread().getName());
            return employees
                    .stream()
                    .map(Employee::getEmail)
                    .collect(Collectors.toList());
        }, executor).thenAcceptAsync((emails) -> {
            System.out.println("Sending Email to Employee: " + Thread.currentThread().getName());
            emails.forEach(EmployeeReminderService::sendEmail);

        }, executor);

      return voidCompletableFuture;

    }

    public static void sendEmail(String email){
        System.out.println("Sending Training Reminders to Email id : " + email);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        EmployeeReminderService employeeReminderService = new EmployeeReminderService();
        employeeReminderService.sendReminderToEmployee().get();

    }




}
