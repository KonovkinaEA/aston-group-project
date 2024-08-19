package org.aston;

import org.aston.creation.file.FilesReader;
import org.aston.creation.file.parsers.BusParser;
import org.aston.creation.file.parsers.RecordParser;
import org.aston.creation.file.parsers.StudentParser;
import org.aston.creation.file.parsers.UserParser;
import org.aston.creation.manual.BusManual;
import org.aston.creation.manual.ManualBuilder;
import org.aston.creation.manual.StudentManual;
import org.aston.creation.manual.UserManual;
import org.aston.creation.random.*;
import org.aston.sorting.SelectionSort;
import org.aston.sorting.Sorter;
import org.aston.sorting.comparators.BusComparator;
import org.aston.sorting.comparators.StudentComparator;
import org.aston.sorting.comparators.UserComparator;
import org.aston.usecase.BinarySearch;
import org.aston.usecase.Search;

import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListManager<?> manager = null;
        while (true) {
            printMenu(manager);
            switch (scanner.nextInt()) {
                case 0:
                    return;
                case 1:
                    System.out.print("""
                            Выберете класс объектов коллекции:
                            1 - Bus
                            2 - Student
                            3 - User
                            """);
                    manager = createListManager(scanner.nextInt());
                    break;
                case 2:
                    if (manager != null) {
                        System.out.print("Введите количество элементов коллекции: ");
                        int size = scanner.nextInt();

                        System.out.println("Сгенерированный список:");
                        System.out.println(manager.generateRandomList(size));
                    } else {
                        printInvalidChoice();
                    }
                    break;
                case 3:
                    if (manager != null) {
                        System.out.println("""
                            В файле запись по каждому классу должна быть на новой строчке, сама запись должна выглядеть так:
                            [Bus/Student/User] = [Данные],[Данные],[Данные]
                            Пример:
                            Student = 2024,4.5,45180
                            """);
                        System.out.println("Введите путь к файлу:");
                        String path = scanner.next();

                        System.out.println("Полученный из файла список:");
                        System.out.println(manager.readListFromFile(path));
                    } else {
                        printInvalidChoice();
                    }
                    break;
                case 4:
                    if (manager != null) {
                        System.out.print("Введите количество элементов коллекции: ");
                        int manualSize = scanner.nextInt();

                        manager.manualCreation(scanner, manualSize);
                        System.out.println(manager.getList());
                    } else {
                        printInvalidChoice();
                    }
                    break;
                case 5:
                    if (manager != null && !manager.getList().isEmpty()) {
                        System.out.println("Отсортированная коллекция:");
                        System.out.println(manager.sort());
                    } else {
                        printInvalidChoice();
                    }
                    break;
                case 6:
                    if (manager != null && !manager.getList().isEmpty()) {
                        System.out.println("Введите элемент для поиска:");
                        int index = manager.search(scanner);
                        if (index < 0) {
                            System.out.println("Элемент не найден.");
                        } else {
                            System.out.println("Номер элемента в коллекции - " + index);
                        }
                    } else {
                        printInvalidChoice();
                    }
                    break;
                default:
                    printInvalidChoice();
            }
        }
    }

    private static ListManager<?> createListManager(int choice) {
        return switch (choice) {
            case 1 -> createListManager(BusRandomBuilder::new, BusParser::new, BusComparator::new, BusManual::new);
            case 2 -> createListManager(StudentRandomBuilder::new, StudentParser::new, StudentComparator::new, StudentManual::new);
            case 3 -> createListManager(UserRandomBuilder::new, UserParser::new, UserComparator::new, UserManual::new);
            default -> throw new InvalidParameterException("Введен номер несуществующего варианта");
        };
    }

    private static <T> ListManager<T> createListManager(Supplier<RandomBuilder<T>> randomBuilderSupplier,
                                                        Supplier<RecordParser<T>> parserSupplier,
                                                        Supplier<Comparator<T>> comparatorSupplier,
                                                        Supplier<ManualBuilder<T>> manualBuilderSupplier) {
        RandomCreator<T> randomCreator = (size) -> randomBuilderSupplier.get().createRandomList(size);
        FilesReader<T> filesReader = new FilesReader<>(parserSupplier.get());
        ManualBuilder<T> manualBuilder = manualBuilderSupplier.get();

        Sorter<T> sorter = new Sorter<>(new SelectionSort<>(), comparatorSupplier.get());
        Search<T> search = new BinarySearch<>(comparatorSupplier.get());

        return new ListManager<>(randomCreator, filesReader, manualBuilder, sorter, search);
    }

    private static void printMenu(ListManager<?> manager) {
        System.out.print("""
                *************************** МЕНЮ **************************
                Чтобы выбрать следующий шаг, введите соответствующую цифру:
                0 - Завершить программу
                1 - Задать базовые параметры коллекции
                """);
        if (manager != null) {
            System.out.print("""
                    2 - Заполнить коллекцию случайно сгенерированными данными
                    3 - Заполнить коллекцию данными из файла
                    4 - Заполнить коллекцию вручную
                    """);
            if (!manager.getList().isEmpty()) {
                System.out.print("""
                        5 - Отсортировать коллекцию
                        6 - Найти элемент в коллекции
                        """);
            }
        }
        System.out.print("""
                ***********************************************************
                """);
    }

    private static void printInvalidChoice() {
        System.out.println("Такого пункта в меню нет, выберете снова");
    }
}
