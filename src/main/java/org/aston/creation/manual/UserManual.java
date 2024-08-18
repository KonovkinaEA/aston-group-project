package org.aston.creation.manual;

import org.aston.model.User;

import java.util.Scanner;

public class UserManual implements ManualBuilder<User> {
    @Override
    public User create(Scanner scanner) {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.next();

        System.out.print("Введите адрес электронной почты пользователя: ");
        String email = scanner.next();

        System.out.print("Введите пароль пользователя (может содержать любые символы): ");
        String password = scanner.next();

        if (name.isEmpty() || !email.contains("@") || password.isEmpty()) {
            System.out.println("\nНеверные данные. Попробуйте еще раз.");
            return null;
        } else {
            System.out.println();
            return new User.Builder()
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password)
                    .build();
        }
    }
}
