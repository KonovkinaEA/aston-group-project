package org.aston;

import org.aston.random_creation.RandomCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("Чтобы выбрать следующий шаг, введите соответствующую цифру:");
            System.out.println("0 - Завершить программу");
            System.out.println("1 - Ввести исходные данные");
            System.out.println("3 - Создание случайного массива заданной величины");
            // TODO: добавить выборы на сортировку, бин. поиск

            switch (scanner.nextInt()) {
                case 0:
                    run = false;
                    break;
                case 1:
                    System.out.println("Введите количество элементов коллекции (число должно быть больше 0):");
                    int size = scanner.nextInt();
                    // TODO: добавить создание массива и заполнения массива
                    break;
                case 2:



                case 3:
                    System.out.println("Введите количество элементов коллекции (число должно быть больше 0):");
                    int limit = scanner.nextInt();
                    System.out.println(new RandomCreator().getRandomList(limit));
                    break;

                // TODO: добавить обработку выборов на сортировку и бин. поиск
            }
        }
    }
}
