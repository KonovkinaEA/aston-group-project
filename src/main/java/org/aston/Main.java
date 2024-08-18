package org.aston;

import org.aston.creation.random.*;
import org.aston.model.Bus;
import org.aston.model.Student;
import org.aston.model.User;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListManager<?> manager = null;

        while (true) {
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
                    System.out.println("5 - Отсортировать коллекцию");
                }
            }
            System.out.print("""
                    ***********************************************************
                    """);

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
                    System.out.print("Введите количество элементов коллекции:");
                    int size = scanner.nextInt();
                    if (manager != null) {
                        System.out.println("Сгенерированный список:");
                        System.out.println(manager.generateRandomList(size));
                    }
            }
        }
    }

    private static ListManager<?> createListManager(int choice) {
        ListManager<?> manager;
        switch (choice) {
            case 1:
                RandomCreator<Bus> busRandomCreator = (size) -> {
                    RandomBuilder<Bus> randomBuilder = new BusRandomBuilder();
                    return randomBuilder.createRandomList(size);
                };
                manager = new ListManager<>(busRandomCreator);
                break;
            case 2:
                RandomCreator<Student> studentRandomCreator = (size) -> {
                    RandomBuilder<Student> randomBuilder = new StudentRandomBuilder();
                    return randomBuilder.createRandomList(size);
                };
                manager = new ListManager<>(studentRandomCreator);
                break;
            case 3:
                RandomCreator<User> userRandomCreator = (size) -> {
                    RandomBuilder<User> randomBuilder = new UserRandomBuilder();
                    return randomBuilder.createRandomList(size);
                };
                manager = new ListManager<>(userRandomCreator);
                break;
            default:
                throw new InvalidParameterException("Введен номер несуществующего варианта");
        }

        return manager;
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ManualBuilder manualBuilder = new ManualBuilder(scanner);
//
//        String tCLass = "";
//        List<BaseEntity> list = new ArrayList<>();
//
//        boolean run = true;
//        while (run) {
//            try {
//                System.out.println("""
//                        *************************** МЕНЮ ***************************
//                        Чтобы выбрать следующий шаг, введите соответствующую цифру:
//                        0 - Завершить программу
//                        1 - Задать базовые параметры коллекции
//                        2 - Заполнить коллекцю вручную
//                        3 - Заполнить коллекцю данными из файла
//                        4 - Заполнить коллекцию случайно сгенерированными данными
//                        5 - Отсортировать коллекцию
//                        6 - Найти элемент в отсортированной коллекции
//                        ************************************************************
//                        """);
//
//                switch (scanner.nextInt()) {
//                    case 0:
//                        run = false;
//                        break;
//                    case 1:
//                        System.out.println("""
//                                Выберете класс объектов коллекции:
//                                1 - Bus
//                                2 - Student
//                                3 - User
//                                """);
//                        tCLass = switch (scanner.nextInt()) {
//                            case 1 -> "Bus";
//                            case 2 -> "Student";
//                            case 3 -> "User";
//                            default -> tCLass;
//                        };
//                        break;
//                    case 2:
//                        System.out.println("Введите количество элементов коллекции:");
//                        int size = scanner.nextInt();
//
//                        for (int i = 0; i < size; i++) {
//                            switch (tCLass) {
//                                case "Bus":
//                                    Bus bus = manualBuilder.createBus(scanner);
//                                    if (bus != null) list.add(bus);
//                                    break;
//                                case "Student":
//                                    Student student = manualBuilder.createStudent(scanner);
//                                    if (student != null) list.add(student);
//                                    break;
//                                case "User":
//                                    User user = manualBuilder.createUser(scanner);
//                                    if (user != null) list.add(user);
//                                    break;
//                            }
//                        }
//                    case 3:
//                        System.out.println("В файле нужно, чтобы каждый класс был на новой строке, а строка выглядела:");
//                        System.out.println("[Bus/Student/User] = Данные класса через запятую");
//                        System.out.println("Пример: Student = 2024,4.5,45180");
//                        System.out.println("Введите путь до файла:");
//
//                        ReaderFiles read = new ReaderFiles();
//                        list = (List<BaseEntity>) read.readFiles(tCLass, scanner.next());
//                    case 4:
//                        System.out.println("Введите количество элементов коллекции (число должно быть больше 0):");
//                        int limit = scanner.nextInt();
//                        list = (List<BaseEntity>) new RandomCreator().generateRandomList(limit);
//                        break;
//                    case 5:
////                        System.out.println("Вы выбрали сортировку. Производится сортировка коллекции...");
////                        Comparator<BaseEntity> comparator = switch (tCLass){
////                            case "Bus" -> new BusNumComparator();
////                            case "Student" -> new StudentNumComparator();
////                            case "User" -> new UserComparator();
////                            default -> throw new IllegalStateException("Unexpected value: " + tCLass);
////                        };
////                        Sorter<BaseEntity> sorter = new Sorter<BaseEntity>(new SelectionSort<BaseEntity>());
////                        List<BaseEntity> sortedList = sorter.sort(list, comparator);
////                        System.out.println("Отсортированная коллекция:");
////                        System.out.println(Arrays.toString(sortedList.toArray()));
//
//                    // TODO: добавить обработку выборов на сортировку и бин. поиск
//                }
//            } catch (Exception e) {
//                System.err.println("Неверный тип.");
//                scanner.nextLine();
//            }
//        }
//    }
}