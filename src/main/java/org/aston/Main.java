package org.aston;

import org.aston.model.User;
import org.aston.random_creation.RandomCreator;
import org.aston.reader_file.ReaderFiles;

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
                    System.out.println("В файле нужно, чтобы каждый класс был на новой строке, а строка выглядела:");
                    System.out.println("[Bus/Student/User] = Данные класса,через запятую");
                    System.out.println("Введите путь до файла");
                    ReaderFiles<User> read = new ReaderFiles();
                    read.readFiles(User.class, scanner.next());//TODO: переменная куда записовать данные
                    break;
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