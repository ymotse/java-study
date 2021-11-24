package com.ymotse.maratona.crudJdbc.service;

import com.ymotse.maratona.crudJdbc.dominio.Producer;
import com.ymotse.maratona.crudJdbc.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void buildMenu(int op) {
        switch (op) {
            case 1:
                findByName();
                break;
            case 2:
                delete();
                break;
            default:
                throw new IllegalArgumentException("Not a valid option");
        }
    }

    private static void findByName() {
        System.out.println("Type the name of empty to all");
        String name = SCANNER.nextLine();
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i < producers.size(); i++) {
            Producer producer = producers.get(i);
            System.out.printf("[%d] - ID: %d | %s%n", i, producer.getId(), producer.getName());
        }
    }

    private static void delete() {
        System.out.println("Type the ID of the producer you want to delete");
        Integer id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();
        if(choice.toLowerCase().startsWith("y")) {
            ProducerRepository.delete(id);
        }
    }
}
