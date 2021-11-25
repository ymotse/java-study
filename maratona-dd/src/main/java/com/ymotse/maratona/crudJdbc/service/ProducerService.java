package com.ymotse.maratona.crudJdbc.service;

import com.ymotse.maratona.crudJdbc.dominio.Producer;
import com.ymotse.maratona.crudJdbc.repository.ProducerRepository;

import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void buildMenu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            default -> throw new IllegalArgumentException("Not a valid option");
        }
    }

    private static void findByName() {
        System.out.println("Type the name of empty to all");
        String name = SCANNER.nextLine();
        ProducerRepository.findByName(name)
                .forEach(p -> {
                    System.out.printf("[%d] - %s%n", p.getId(), p.getName());
                });
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

    private static void save() {
        System.out.println("Type the name of the producer");
        String name = SCANNER.nextLine();
        Producer producer = Producer.builder().name(name).build();
        ProducerRepository.save(producer);
    }
}
