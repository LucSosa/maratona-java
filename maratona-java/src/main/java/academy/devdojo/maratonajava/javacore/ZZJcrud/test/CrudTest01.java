package academy.devdojo.maratonajava.javacore.ZZJcrud.test;

import academy.devdojo.maratonajava.javacore.ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            producerMenu();
            op = Integer.parseInt(SCANNER.nextLine());
            if (op == 0) break;
            ProducerService.menu(op);
        }
    }

    public static void menu(){
        System.out.println("Type the number of your operation");
        System.out.println("");
        System.out.println("");
    }

    private static void producerMenu() {
        System.out.println("Type the number of your operation");
        System.out.println("1. Search for producer");
        System.out.println("2. Delete producer");
        System.out.println("3. Save producer");
        System.out.println("4. Update producer");
        System.out.println("9. Exit");
    }

    private static void animeMenu() {
        System.out.println("Type the number of your operation");
        System.out.println("1. Search for anime");
        System.out.println("2. Delete anime");
        System.out.println("3. Save anime");
        System.out.println("4. Update anime");
        System.out.println("9. Exit");
    }
}