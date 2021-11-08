package com.ymotse.maratona.jdbc.execute;

import com.ymotse.maratona.jdbc.dominio.Producer;
import com.ymotse.maratona.jdbc.repository.ProducerRepository;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.ProducerBuilder.builder().name("NHK").build();
        ProducerRepository.save(producer);
    }
}
