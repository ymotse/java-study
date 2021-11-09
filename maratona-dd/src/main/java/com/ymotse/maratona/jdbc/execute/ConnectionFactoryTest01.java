package com.ymotse.maratona.jdbc.execute;

import com.ymotse.maratona.jdbc.dominio.Producer;
import com.ymotse.maratona.jdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
//        Producer producer = Producer.builder().name("Universal Studio").build();
//        ProducerService.save(producer);
//        ProducerService.delete(6);
//        Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
//        ProducerService.update(producerToUpdate);
        List<Producer> producers = ProducerService.findAll();
        log.info("Producers found '{}'", producers);
    }
}
