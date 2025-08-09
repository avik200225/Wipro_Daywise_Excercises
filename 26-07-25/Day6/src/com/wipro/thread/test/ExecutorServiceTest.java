package com.wipro.thread.test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.wipro.thread.ExecutorServiceDemo.PrintTask;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            executor.submit(new PrintTask(i));
        }
        executor.shutdown();
    }
}
