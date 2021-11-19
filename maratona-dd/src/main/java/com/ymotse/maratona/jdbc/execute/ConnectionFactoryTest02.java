package com.ymotse.maratona.jdbc.execute;

import com.ymotse.maratona.jdbc.dominio.Producer;
import com.ymotse.maratona.jdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {

    public static void main(String[] args) {
//        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("Fox");
//        log.info("Producers '{}'", producers);

//        Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
//        ProducerServiceRowSet.updateJdbcRowSet(producerToUpdate);

        Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
        ProducerServiceRowSet.updateCachedRowSet(producerToUpdate);
    }

}
