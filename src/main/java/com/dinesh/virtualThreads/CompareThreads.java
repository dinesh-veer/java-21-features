package com.dinesh.virtualThreads;

public class CompareThreads {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("---------------------------------------------------");

        System.out.println("Platform thread:");

        Thread platformThread = Thread.ofPlatform().start(() ->{
            System.out.println("Platform thread :" + Thread.currentThread());
        });


        System.out.println("Virtual thread:");

        Thread virtualThread = Thread.ofVirtual().start(() ->{
            System.out.println("Virtual thread :" + Thread.currentThread());
        });

        platformThread.join();
        virtualThread.join();

        System.out.println("----------------------------------------------------");
    }
}
