package org.aston;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("Чтобы выбрать следующий шаг, введите соответствующую цифру:");
            System.out.println("0 - Завершить программу");
            System.out.println("1 - Ввести исходные данные");
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
                // TODO: добавить обработку выборов на сортировку и бин. поиск
            }
        }
    }
}
