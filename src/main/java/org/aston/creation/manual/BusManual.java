package org.aston.creation.manual;

import org.aston.model.BaseEntity;
import org.aston.model.Bus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusManual implements IManualBuilder<Bus>{
    private Scanner scanner;

    public BusManual(){
    }
    @Override
    public Bus create() {
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
}

