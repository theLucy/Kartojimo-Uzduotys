package dev.laurynas;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<Long> {

    private final long n;

    public TaskWithResult(long n) {
        this.n = n;
    }

    @Override
    public Long call() {
        long suma = 0;
        for (long i = 0; i < n; i++) {
            suma += i;
            try {
                Thread.sleep(50);
            } catch (Exception ignored) {}
        }
        return suma;
    }
}
