package dev.laurynas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class App {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        /*Runnable task1 = new Task(counter, 20);
        Runnable task2 = new Task(counter, 30);
        Runnable task3 = new Task(counter, 40);

        Thread th1 = new Thread(task1, "Gija1");
        Thread th2 = new Thread(task2, "Gija2");
        Thread th3 = new Thread(task3, "Gija3");

        th1.start();
        th2.start();
        th3.start();

        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            System.out.println("Nepavyko laukti giju!");
        }

        System.out.println(counter.get());*/

        /*ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        TaskWithResult task1 = new TaskWithResult(100);
        TaskWithResult task2 = new TaskWithResult(100);
        TaskWithResult task3 = new TaskWithResult(100);
        TaskWithResult task4 = new TaskWithResult(100);

        scheduler.scheduleAtFixedRate(() -> System.out.println("Praejo sekunde"), 1, 1, TimeUnit.SECONDS);

        List<TaskWithResult> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        List<Future<Long>> rezultatai = new ArrayList<>();
        try {
            for (TaskWithResult task : tasks) {
                rezultatai.add(singleThreadExecutor.submit(task));
            }
        } catch (Exception ignored) {
        }

        singleThreadExecutor.shutdown();

        System.out.println("Uzduotys pateiktos!");
        long rezultatasLong = 0;

        System.out.println("Laukiama 1 sekunde.");
        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {}
        System.out.println("Praejo 1 sekunde.");

        rezultatai.get(0).cancel(false);
        rezultatai.get(0).state();
        rezultatai.get(1).cancel(false);
        rezultatai.get(2).cancel(false);
        rezultatai.get(3).cancel(false);

        try {
            rezultatasLong = rezultatai.get(0).get();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Uzduotis 1 padaryta ir rezultatas gautas!");
        System.out.println(rezultatasLong);

        CompletableFuture<Integer> uzduotis = CompletableFuture.completedFuture(5);*/

        JFrame frame = new JFrame("App");
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel label = new JLabel("");
        JButton button = new JButton("Spausk");

        label.setFont(button.getFont().deriveFont(25f));
        button.setFont(button.getFont().deriveFont(25f));

        frame.getContentPane().add(label);
        frame.getContentPane().add(button);

        CompletableFuture<Long> atsakymas = uzduotis(70);
        atsakymas.thenRunAsync(() -> JOptionPane.showMessageDialog(frame, "Done!"));

        button.addActionListener(e -> {
            try {
                label.setText(String.valueOf(atsakymas.get()));
            } catch (Exception ignored) {
            }
        });

        frame.setVisible(true);



    }

    public static CompletableFuture<Long> uzduotis(long n) {
        return CompletableFuture.supplyAsync(() -> {
            long suma = 0;
            for (long i = 0; i < n; i++) {
                suma += i;
                try {
                    Thread.sleep(50);
                } catch (Exception ignored) {}
            }
            return suma;
        });

    }

}