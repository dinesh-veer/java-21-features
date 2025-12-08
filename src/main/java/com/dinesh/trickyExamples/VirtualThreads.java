package com.dinesh.trickyExamples;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreads {

    private static void work() {
        System.out.println("Executing thread :" + Thread.currentThread());
    }

    public static void virtualThreadDirect() throws InterruptedException {
        Runnable task = () -> System.out.println("Running in direct virtual thread");

        Thread t = Thread.ofVirtual().start(task);
        t.join(); // Wait for the thread to finish
    }

    public static void executorService() throws Exception {
        Runnable task = () -> System.out.println("Running in executor-managed virtual thread");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> future = executor.submit(task);
            future.get(); // Wait for completion and handle exceptions
        }
    }


    public static void main(String[] args) throws InterruptedException, Exception {
        //Difference Between below 2 Declataion
        Thread.ofVirtual().start(() -> work());
        Executors.newVirtualThreadPerTaskExecutor().submit(() -> work());
        Thread.sleep(1000);

        virtualThreadDirect();

        executorService();
        //|---------------------------------------------------------------------------------------------------------------------------------------|
        //| Feature                       | `Thread.ofVirtual().start()`                  | `Executors.newVirtualThreadPerTaskExecutor().submit()`|
        //|-------------------------------|-----------------------------------------------|-------------------------------------------------------|
        //| **Goal**                      | Direct thread creation                        | Abstracted task management                            |
        //| **Return Type**               | `Thread`                                      | `Future<?>`                                           |
        //| **Lifecycle Control**         | Manual (`join()`, `isAlive()`)                | Managed via `ExecutorService`                         |
        //| **Best Use Case**             | Simple, isolated tasks                        | Multiple tasks, structured concurrency                |
        //| **Error Handling**            | Manual via try-catch                          | Via `Future.get()`                                    |
        //|---------------------------------------------------------------------------------------------------------------------------------------|

//      Q: What happens if a virtual thread performs blocking I/O (e.g., JDBC)?
//
//       Answer:The virtual thread is parked and the carrier (OS thread) is released.
//              When the blocking operation completes, the virtual thread resumes on possibly another carrier.
//              So it doesn’t block an OS thread, which is why virtual threads scale so well.


        //is below code is safe

        var executor = Executors.newVirtualThreadPerTaskExecutor();
        try (executor) {
            for (int i = 0; i < 10_000_000; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                });
            }
        }

//        Answer: Safe (in principle).
//
//        Each submit creates a virtual thread — not an OS thread.
//        Java can easily schedule millions since they are lightweight.
//        try (executor) ensures graceful shutdown after all threads finish.
//        The only constraint: you may run out of memory if each thread holds too much local state.

        try (var exec = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000_000; i++) {
                exec.submit(() -> {
                    try {
                        System.in.read();  // blocking call
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        //Above code will freeze
        //
        // Virtual threads stop scaling
        //
        //Entire system freezes
        //
        //Only one thread can read from System.in

    }
}
