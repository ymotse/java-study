package com.ymotse.maratona.jdbc.service;

import com.ymotse.maratona.jdbc.dominio.Producer;
import com.ymotse.maratona.jdbc.repository.ProducerRepository;

import java.util.List;

public class ProducerService {

    public static void save(Producer producer) {
        ProducerRepository.save(producer);
    }

    public static void delete(Integer id) {
        requireValidId(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer) {
        requireValidId(producer.getId());
        ProducerRepository.update(producer);
    }

    private static void requireValidId(Integer id) {
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid value for ID");
        }
    }

    public static List<Producer> findAll() {
        return ProducerRepository.findAll();
    }

    public static List<Producer> findByName(String name) {
        return ProducerRepository.findByName(name);
    }
    public static void showProducerMetadata() {
        ProducerRepository.showProducerMetadata();
    }

    public static void showDriverMetadata() {
        ProducerRepository.showDriverMetadata();
    }

    public static void showTypeScrollWorking() {
        ProducerRepository.showTypeScrollWorking();
    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        return ProducerRepository.findByNameAndUpdateToUpperCase(name);
    }

    public static List<Producer> findByNameAndInsertThenNotFound(String name) {
        return ProducerRepository.findByNameAndInsertThenNotFound(name);
    }

    public static void findByNameAndDelete(String name) {
        ProducerRepository.findByNameAndDelete(name);
    }

    public static List<Producer> findByNamePreparedStatement(String name) {
        return ProducerRepository.findByNamePreparedStatement(name);
    }
    public static void updatePreparedStatement(Producer producer) {
        requireValidId(producer.getId());
        ProducerRepository.updatePreparedStatement(producer);
    }

    public static List<Producer> findByNameCallableStatement(String name) {
        return ProducerRepository.findByNameCallableStatement(name);
    }

}

