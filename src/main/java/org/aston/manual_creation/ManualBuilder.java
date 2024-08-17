package org.aston.manual_creation;



import org.aston.model.Bus;
import org.aston.model.Student;
import org.aston.model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManualBuilder {
    private Scanner scanner;

    public ManualBuilder(Scanner scanner){
        this.scanner = scanner;
    }
    public Bus createBus(Scanner scanner) {
        try {
            System.out.println("Введите номер автобуса:");
            String number = scanner.nextLine();

            System.out.println("Введите модель автобуса:");
            String model = scanner.nextLine();

            System.out.println("Введите пробег Автобуса:");
            int mileage = scanner.nextInt();

            if (number.isEmpty() || model.isEmpty() || mileage < 0) {
                System.out.println("Неверные данные. Попробуйте еще раз.");
                return null;
            } else {
                return new Bus.Builder()
                        .setNumber(number)
                        .setModel(model)
                        .setMileage(mileage)
                        .build();
            }

        } catch (InputMismatchException e) {
            System.out.println("Неверная запись, введите правильные данные.");
            scanner.nextLine(); // Clean buffer
            return null;
        }
    }

    public Student createStudent(Scanner scanner) {
        try {
            System.out.println("Введите студент номер группы:");
            String groupNumber = scanner.nextLine();

            System.out.println("Введите средний балл студента:");
            double averageGrade = scanner.nextDouble();

            System.out.println("Введите номер зачетной книжки)");
            scanner.nextLine();
            String recordBookNumber = scanner.nextLine();

            if (groupNumber.isEmpty() || averageGrade < 0 || averageGrade > 5 || recordBookNumber.isEmpty()) {
                System.out.println("Неверные данные. Попробуйте еще раз.");
                return null;
            } else {
                return new Student.Builder()
                        .setGroupNumber(groupNumber)
                        .setAverageGrade(averageGrade)
                        .setRecordBookNumber(recordBookNumber)
                        .build();
            }

        } catch (InputMismatchException e) {
            System.out.println("Неверная запись, введите правильные данные.");
            scanner.nextLine(); // Clean buffer
            return null;
        }
    }

    public User createUser(Scanner scanner) {
        System.out.println("Введите имя пользователя:");
        String name = scanner.nextLine();

        System.out.println("Введите адрес электронной почты пользователя:");
        String email = scanner.nextLine();

        System.out.println("Введите пароль пользователя:");
        String password = scanner.nextLine();

        if (name.isEmpty() || !email.contains("@") || password.length() < 6) {
            System.out.println("Неверные данные. Попробуйте еще раз.");
            return null;
        } else {
            return new User.Builder()
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password)
                    .build();
        }

    }
}
