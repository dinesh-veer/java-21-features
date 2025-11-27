package com.dinesh.virtualThreads;

import java.util.LinkedList;

public class ManyVirtualThreads {
    public static void main(String[] args) {

        System.out.println("--------------------------------------------------");

        for (int i = 1; i <= 10_000; i++) {
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(1000);  // blocking I/O simulated
                } catch (InterruptedException _) {
                    System.err.println("Thread interrupted");
                }
            });
        }
        System.out.println("Launched 10,000 virtual threads!");
        System.out.println("--------------------------------------------------");
    }
}
