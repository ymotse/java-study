package com.ymotse.maratona.threads.execute;


class ThreadExampleRunnable2 implements Runnable {
    private final String c;

    public ThreadExampleRunnable2(String c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        for (int i = 0; i < 200; i++) {
            System.out.print(c);
            if(i % 100 == 0) {
                System.out.println();
            }
            Thread.yield();
        }
    }
}

// Daemon x User
public class ThreadTest02 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadExampleRunnable2("KA"));
        Thread t2 = new Thread(new ThreadExampleRunnable2("ME"));
        t1.start();
        t1.join();
        t2.start();
    }

}
