package com.ymotse.maratona.concorrencia.execute;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest01 {

    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void beeper() {
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) + " beep");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

//        executor.schedule(r, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS); //conta quando thread acordar
//        ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS); //continuo independente do sleep

        executor.schedule(() -> {
            System.out.println("Cancelando o scheduleWithFixedDelay");
            scheduleWithFixedDelay.cancel(false);
            executor.shutdown();
        }, 10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        beeper();
    }

}
