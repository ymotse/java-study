package com.ymotse.maratona.concorrencia.execute;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {

    public static void main(String[] args) throws InterruptedException {
        // ConcurrentLinkedQueur, SynchronousQueue, LinkedBlockingQueue
        TransferQueue<Object> tq  = new LinkedTransferQueue<>();
        System.out.println(tq.add("John"));
        System.out.println(tq.offer("Scott", 5, TimeUnit.SECONDS));
        tq.put("Mariah");
        if(tq.hasWaitingConsumer()) {
            tq.transfer("Goku");
        }
        System.out.println(tq.tryTransfer("Kuririn"));
        System.out.println(tq.tryTransfer("Gohan", 5, TimeUnit.SECONDS));
        System.out.println(tq.element());
        System.out.println(tq.poll());
        System.out.println(tq.take());
        System.out.println(tq.remainingCapacity());
    }

}
