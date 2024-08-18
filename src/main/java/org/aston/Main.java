package org.aston;

import org.aston.creation.file.FilesReader;
import org.aston.creation.file.parsers.BusParser;
import org.aston.creation.file.parsers.RecordParser;
import org.aston.creation.file.parsers.StudentParser;
import org.aston.creation.file.parsers.UserParser;
import org.aston.creation.random.*;

import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.function.Supplier;

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
                    manager = createListManager(scanner.nextInt());
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
