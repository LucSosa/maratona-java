package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> updade();
            default -> throw new IllegalArgumentException("Not a valid option");
        }
    }

    private static void findByName() {
        System.out.println("Type the name or empty to all");
        String name = SCANNER.nextLine();
        ProducerRepository
                .findByName(name)
                .forEach(p ->
                        System.out.printf("[%d] - %s%n", p.getId(), p.getName()));
    }

    private static void delete() {
        System.out.println("Type the id of the producer you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? S/N");
        String choice = SCANNER.nextLine();
        if (choice.toLowerCase().startsWith("s")) {
            ProducerRepository.delete(id);
        }
    }

    private static void save() {
        System.out.println("Type the name of the producer");
        String name = SCANNER.nextLine();
        Producer producer = Producer.builder().name(name).build();
        ProducerRepository.save(producer);
    }

    private static void updade() {
        System.out.println("Type the id of the object you want to update");
        Optional<Producer> producerOptional = ProducerRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        if (producerOptional.isEmpty()){
            System.out.println("Producer not found");
            return;
        }
        Producer producerFromDb = producerOptional.get();
        System.out.println("Producer found " + producerFromDb);
        System.out.println("Type the new name or enter to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? producerFromDb.getName() : name;
        Producer producerToUpdate = Producer.builder()
                .id(producerFromDb.getId())
                .name(name)
                .build();
        ProducerRepository.update(producerToUpdate);
    }
}
