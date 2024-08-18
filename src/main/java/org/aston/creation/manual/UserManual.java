package org.aston.creation.manual;

import org.aston.model.User;

import java.util.Scanner;

public class UserManual implements IManualBuilder<User> {
    private Scanner scanner;
    public UserManual() {
    }

    @Override
    public User create() {
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
