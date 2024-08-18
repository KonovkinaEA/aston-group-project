package org.aston.creation.manual;

import org.aston.model.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManual implements IManualBuilder<Student>{
    private Scanner scanner;
    public StudentManual() {
    }

    @Override
    public Student create() {
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
}
