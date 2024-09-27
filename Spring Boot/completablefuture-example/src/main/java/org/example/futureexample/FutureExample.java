package org.example.futureexample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {


    // future we can run manually
    // future is not able to handle exception handling
    // we cannot use multiple future object in a chain


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<List<Integer>> submit = service.submit(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            delayMin(1);
            return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        });


        List<Integer>  ans  =  submit.get();
        System.out.println(ans);




        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.get();
        completableFuture.complete("return some dummy data");






    }


    public static void delayMin(long min){
        try {
           TimeUnit.MINUTES.sleep(min);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



}
