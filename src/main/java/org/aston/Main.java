package org.aston;

import org.aston.manual_creation.ManualBuilder;
import org.aston.model.Bus;
import org.aston.model.Student;
import org.aston.model.User;
import org.aston.random_creation.RandomCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManualBuilder manualBuilder = new ManualBuilder(scanner);
        List<Bus> buses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<User> users = new ArrayList<>();

        boolean run = true;
        while (run) {
            try {
                System.out.println("""
                            *************************** МЕНЮ ***************************
                            Чтобы выбрать следующий шаг, введите соответствующую цифру:
                            0 - Завершить программу
                            1 - Ввести исходные данные
                            2 - Заполните данные вручную
                            3 - Создание случайного массива заданной величины
                            *************************************************************
                        """);

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
                        System.out.println("Введите тип объекта, который вы хотите создать: Автобус, Студент, Пользователь.");
                        String type = scanner.nextLine();

                        switch (type) {
                            case "Автобус":
                                Bus bus = manualBuilder.createBus(scanner);
                                if (bus != null) {
                                    buses.add(bus);
                                }
                                break;
                            case "Студент":
                                Student student = manualBuilder.createStudent(scanner);
                                if (student != null) {
                                    students.add(student);
                                }
                                break;
                            case "Пользователь":
                                User user = manualBuilder.createUser(scanner);
                                if (user != null) {
                                    users.add(user);
                                }
                                break;
                            default:
                                System.err.println("Неверный тип.");
                                break;
                        }


                    case 3:
                        System.out.println("Введите количество элементов коллекции (число должно быть больше 0):");
                        int limit = scanner.nextInt();
                        System.out.println(new RandomCreator().getRandomList(limit));
                        break;

                    // TODO: добавить обработку выборов на сортировку и бин. поиск
                }
            } catch (Exception e){
                System.err.println("Неверный тип.");
                scanner.nextLine();
            }
        }
    }
}
