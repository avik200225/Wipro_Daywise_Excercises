package com.wipro.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo{
public static class PrintTask implements Runnable {
    private final int taskId;

    public PrintTask(int taskId) {
        this.taskId = taskId;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Task " + taskId + " - Number: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Task " + taskId + " interrupted.");
            }
        }
    }
}
}
    
   

