package org.aston.creation.manual;

import org.aston.model.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManual implements ManualBuilder<Student> {
    @Override
    public Student create(Scanner scanner) {
        try {
            System.out.print("Введите студент номер группы (может содержать любые символы): ");
            String groupNumber = scanner.next();

            System.out.print("Введите средний балл студента (дробное число от 0 до 5, ex. 4.8): ");
            double averageGrade = scanner.nextDouble();

            System.out.print("Введите номер зачетной книжки (может содержать любые символы): ");
            String recordBookNumber = scanner.next();

            if (groupNumber.isEmpty() || averageGrade < 0 || averageGrade > 5 || recordBookNumber.isEmpty()) {
                System.err.println("\nНеверные данные. Попробуйте еще раз.");
                return null;
            } else {
                System.out.println();
                return new Student.Builder()
                        .setGroupNumber(groupNumber)
                        .setAverageGrade(averageGrade)
                        .setRecordBookNumber(recordBookNumber)
                        .build();
            }
        } catch (InputMismatchException e) {
            System.err.println("\nНеверная запись, введите правильные данные.");
            return null;
        }
    }
}
