package org.aston.creation.manual;

import org.aston.model.Bus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusManual implements ManualBuilder<Bus> {
    @Override
    public Bus create(Scanner scanner) {
        try {
            System.out.print("Введите номер автобуса (может содержать любые символы): ");
            String number = scanner.next();

            System.out.print("Введите модель автобуса (может содержать любые символы): ");
            String model = scanner.next();

            System.out.print("Введите пробег автобуса (целое число больше 0): ");
            int mileage = scanner.nextInt();

            if (number.isEmpty() || model.isEmpty() || mileage < 0) {
                System.err.println("\nНеверные данные. Попробуйте еще раз.");
                return null;
            } else {
                System.out.println();
                return new Bus.Builder()
                        .setNumber(number)
                        .setModel(model)
                        .setMileage(mileage)
                        .build();
            }
        } catch (InputMismatchException e) {
            System.err.println("\nНеверная запись, введите правильные данные.");
            return null;
        }
    }
}
