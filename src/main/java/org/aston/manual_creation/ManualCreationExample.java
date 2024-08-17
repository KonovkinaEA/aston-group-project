//package org.aston.manual_creation;
/**
//
//
//import org.aston.model.Bus;
//import org.aston.model.Student;
//import org.aston.model.User;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ManualCreationExample {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ManualBuilder manualBuilder = new ManualBuilder(scanner);
//        List<Bus> buses = new ArrayList<>();
//        List<Student> students = new ArrayList<>();
//        List<User> users = new ArrayList<>();
//        boolean isExit =  false;
//
//        while (!isExit) {
//            try {
//                System.out.println("""
//                        Напишите вариант:
//                        0. Выйти из программы.
//                        1. Заполнить данные.
//                                    """);
//
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//
//                if (choice == 1) {
//                    System.out.println("Введите тип объекта, который вы хотите создать: Автобус, Студент, Пользователь.");
//                    String type = scanner.nextLine();
//
//                    switch (type) {
//                        case "Автобус":
//                            Bus bus = manualBuilder.createBus(scanner);
//                            if (bus != null) {
//                                buses.add(bus);
//                            }
//                            break;
//                        case "Студент":
//                            Student student = manualBuilder.createStudent(scanner);
//                            if (student != null) {
//                                students.add(student);
//                            }
//                            break;
//                        case "Пользователь":
//                            User user = manualBuilder.createUser(scanner);
//                            if (user != null) {
//                                users.add(user);
//                            }
//                            break;
//                        default:
//                            System.err.println("Неверный тип.");
//                            break;
//                    }
//                } else if (choice == 0) {
//                    isExit = true;
//                }
//            } catch (Exception e){
//                System.err.println("Неверный тип.");
//                scanner.nextLine();
//            }
//        }
//    }
//}
 **/
