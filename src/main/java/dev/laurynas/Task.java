package dev.laurynas;

import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable {

    private final AtomicInteger counter;
    private final int n;

    public Task(AtomicInteger counter, int n) {
        this.counter = counter;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            counter.incrementAndGet();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

            }
        }
    }
}
