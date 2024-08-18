package org.aston;

import org.aston.creation.file.ReaderFiles;
import org.aston.creation.manual.ManualBuilder;
import org.aston.creation.random.RandomCreator;
import org.aston.model.BaseEntity;
import org.aston.model.Bus;
import org.aston.model.Student;
import org.aston.model.User;
import org.aston.sorting.comparators.*;
import org.aston.sorting.Sorter;
import org.aston.sorting.SelectionSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManualBuilder manualBuilder = new ManualBuilder(scanner);

        String tCLass = "";
        List<BaseEntity> list = new ArrayList<>();

        boolean run = true;
        while (run) {
            try {
                System.out.println("""
                        *************************** МЕНЮ ***************************
                        Чтобы выбрать следующий шаг, введите соответствующую цифру:
                        0 - Завершить программу
                        1 - Задать базовые параметры коллекции
                        2 - Заполнить коллекцю вручную
                        3 - Заполнить коллекцю данными из файла
                        4 - Заполнить коллекцию случайно сгенерированными данными
                        5 - Отсортировать коллекцию
                        6 - Найти элемент в отсортированной коллекции
                        ************************************************************
                        """);

                switch (scanner.nextInt()) {
                    case 0:
                        run = false;
                        break;
                    case 1:
                        System.out.println("""
                                Выберете класс объектов коллекции:
                                1 - Bus
                                2 - Student
                                3 - User
                                """);
                        tCLass = switch (scanner.nextInt()) {
                            case 1 -> "Bus";
                            case 2 -> "Student";
                            case 3 -> "User";
                            default -> tCLass;
                        };
                        break;
                    case 2:
                        System.out.println("Введите количество элементов коллекции:");
                        int size = scanner.nextInt();

                        for (int i = 0; i < size; i++) {
                            switch (tCLass) {
                                case "Bus":
                                    Bus bus = manualBuilder.createBus(scanner);
                                    if (bus != null) list.add(bus);
                                    break;
                                case "Student":
                                    Student student = manualBuilder.createStudent(scanner);
                                    if (student != null) list.add(student);
                                    break;
                                case "User":
                                    User user = manualBuilder.createUser(scanner);
                                    if (user != null) list.add(user);
                                    break;
                            }
                        }
                    case 3:
                        System.out.println("В файле нужно, чтобы каждый класс был на новой строке, а строка выглядела:");
                        System.out.println("[Bus/Student/User] = Данные класса через запятую");
                        System.out.println("Пример: Student = 2024,4.5,45180");
                        System.out.println("Введите путь до файла:");

                        ReaderFiles read = new ReaderFiles();
                        list = (List<BaseEntity>) read.readFiles(tCLass, scanner.next());
                    case 4:
                        System.out.println("Введите количество элементов коллекции (число должно быть больше 0):");
                        int limit = scanner.nextInt();
                        list = (List<BaseEntity>) new RandomCreator().getRandomList(limit);
                        break;
                    case 5:
                        System.out.println("Вы выбрали сортировку. Производится сортировка коллекции...");
                        Comparator<BaseEntity> comparator = switch (tCLass){
                            case "Bus" -> new BusNumComparator();
                            case "Student" -> new StudentNumComparator();
                            case "User" -> new UserComparator();
                            default -> throw new IllegalStateException("Unexpected value: " + tCLass);
                        };
                        Sorter<BaseEntity> sorter = new Sorter<BaseEntity>(new SelectionSort<BaseEntity>());
                        List<BaseEntity> sortedList = sorter.sort(list, comparator);
                        System.out.println("Отсортированная коллекция:");
                        System.out.println(Arrays.toString(sortedList.toArray()));

                    // TODO: добавить обработку выборов на сортировку и бин. поиск
                }
            } catch (Exception e) {
                System.err.println("Неверный тип.");
                scanner.nextLine();
            }
        }
    }
}