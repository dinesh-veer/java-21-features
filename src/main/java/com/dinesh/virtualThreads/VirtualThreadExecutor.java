package com.dinesh.virtualThreads;

import java.util.concurrent.Executors;

public class VirtualThreadExecutor {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");

        try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 0; i < 10_000; i++) {
                int taskCount = i;
                executor.submit(() ->{
                    try {
                        Thread.sleep(200);
                        System.out.println("Task " + taskCount + " done by " + Thread.currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        System.out.println("--------------------------------------------------");
    }
}
