package org.aston;

import org.aston.creation.file.FilesReader;
import org.aston.creation.file.parsers.BusParser;
import org.aston.creation.file.parsers.RecordParser;
import org.aston.creation.file.parsers.StudentParser;
import org.aston.creation.file.parsers.UserParser;
import org.aston.creation.random.*;
import org.aston.model.*;
import org.aston.sorting.SelectionSort;
import org.aston.sorting.Sorter;
import org.aston.sorting.comparators.*;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListManager<?> manager = null;
        int classType = -1;

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
                    System.out.println("""
                            5 - Отсортировать коллекцию
                            6 - Найти элемент в отсортированной коллекции
                            """);
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
                    classType = scanner.nextInt();
                    manager = createListManager(classType);
                    break;
                case 2:
                    System.out.print("Введите количество элементов коллекции:");
                    int size = scanner.nextInt();
                    if (manager != null) {
                        System.out.println("Сгенерированный список:");
                        System.out.println(manager.generateRandomList(size));
                    }
                    break;
                case 3:
                    System.out.println("""
                            В файле запись по каждому классу должна быть на новой строчке, сама запись должна выглядеть так:
                            [Bus/Student/User] = [Данные],[Данные],[Данные]
                            Пример:
                            Student = 2024,4.5,45180
                            """);
                    System.out.println("Введите путь к файлу:");
                    String path = scanner.next();
                    if (manager != null) {
                        System.out.println("Полученный из файла список:");
                        System.out.println(manager.readListFromFile(path));
                    }
                case 5:
                    System.out.println("Вы выбрали сортировку коллекции. Сортировка выполняется... ");
                    Sorter<?> sorter = switch (classType){
                        case 1 -> new Sorter<Bus>(new SelectionSort<>(), new BusComparator());
                        case 2 -> new Sorter<Student>(new SelectionSort<>(), new StudentComparator());
                        case 3 -> new Sorter<User>(new SelectionSort<>(), new UserComparator());
                        default -> throw new InvalidParameterException("Введен номер несуществующего варианта");
                    };

                    List<?> sortedList = sorter.sort(manager.getList());

                    System.out.println("Отсортированная коллекция:");
                    System.out.println(Arrays.toString(sortedList.toArray()));
            }
        }
    }

    private static ListManager<?> createListManager(int choice) {
        return switch (choice) {
            case 1 -> createListManager(BusRandomBuilder::new, BusParser::new);
            case 2 -> createListManager(StudentRandomBuilder::new, StudentParser::new);
            case 3 -> createListManager(UserRandomBuilder::new, UserParser::new);
            default -> throw new InvalidParameterException("Введен номер несуществующего варианта");
        };
    }

    private static <T> ListManager<T> createListManager(Supplier<RandomBuilder<T>> randomBuilderSupplier,
                                                        Supplier<RecordParser<T>> parserSupplier) {
        RandomCreator<T> randomCreator = (size) -> randomBuilderSupplier.get().createRandomList(size);
        FilesReader<T> filesReader = new FilesReader<>(parserSupplier.get());
        return new ListManager<>(randomCreator, filesReader);
    }
}
