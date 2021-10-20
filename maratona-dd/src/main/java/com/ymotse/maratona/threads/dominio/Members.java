package com.ymotse.maratona.threads.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        synchronized (emails) {
            return emails.size();
        }
    }

    public void addMemberEmail(String email) {
        synchronized (this.emails) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " adicionou email na lista.");
            this.emails.add(email);
            this.emails.notifyAll();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " cheking if there are emails");
        synchronized (this.emails) {
            while(this.emails.size() == 0) {
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " nao tem email disponivel na lista. Entrando em modo de espera.");
                this.emails.wait();
            }
            return this.emails.poll();
        }
    }

    public void close() {
        open = false;
        synchronized (this.emails) {
            System.out.println(Thread.currentThread().getName() + " notificando todo mundo que nao estamos mais pegando emails.");
            this.emails.notifyAll();
        }
    }

}
