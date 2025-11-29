package com.dinesh.virtualThreads;

public class SingleVirtualThreadExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("---------------------------------------------------");
        Runnable runnable = () -> System.out.println("Running thread :" + Thread.currentThread());

        Thread virtualThread = Thread.startVirtualThread(runnable);
        // Wait for the virtual thread to finish its work
        virtualThread.join();

        System.out.println(STR."Main thread completed :\{Thread.currentThread()}");
        System.out.println("--------------------------------------------------");

    }
}
