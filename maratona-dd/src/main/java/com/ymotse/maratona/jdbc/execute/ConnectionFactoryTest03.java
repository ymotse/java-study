package com.ymotse.maratona.jdbc.execute;

import com.ymotse.maratona.jdbc.dominio.Producer;
import com.ymotse.maratona.jdbc.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {

    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("Toei Animation").build();
        Producer producer2 = Producer.builder().name("White Fox").build();
        Producer producer3 = Producer.builder().name("Studio Shibli").build();
        ProducerService.saveTransaction(List.of(producer1, producer2, producer3));
    }
}
