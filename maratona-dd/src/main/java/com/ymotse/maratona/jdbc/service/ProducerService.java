package com.ymotse.maratona.jdbc.service;

import com.ymotse.maratona.jdbc.dominio.Producer;
import com.ymotse.maratona.jdbc.repository.ProducerRepository;

public class ProducerService {

    public static void save(Producer producer) {
        ProducerRepository.save(producer);
    }

    public static void delete(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException("Invalid value for ID");
        }
        ProducerRepository.delete(id);
    }
}
