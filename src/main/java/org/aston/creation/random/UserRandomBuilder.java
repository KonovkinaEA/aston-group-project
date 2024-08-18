package org.aston.creation.random;

import org.aston.model.User;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class UserRandomBuilder implements RandomBuilder<User> {

    private static final int ZERO = 0;
    private static final int MIN_LIMIT = 48; // letter 'a' = 97, 'A' = 65
    private static final int MAX_LIMIT = 122; // letter 'z' = 122, 'Z' = 90
    private static final int PASSWORD_LENGTH = 8;
    private static final int MAX_EMAIL_NUMBER = 100;
    private static final List<String> USER_NAME = UserNameEnum.getAllUserNames();


    private static String createPassword(){
        Random random = new Random();

        return random.ints(MIN_LIMIT, MAX_LIMIT + 1)
                .limit(PASSWORD_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String createUserName(){
        return USER_NAME.get((int) RandomBuilder.getRandomNumber(USER_NAME.size(), ZERO));
    }

    private static User createUser() {
        String name = createUserName();

        return new User.Builder()
                .setName(name)
                .setPassword(createPassword())
                .setEmail(name + (int) RandomBuilder.getRandomNumber(MAX_EMAIL_NUMBER, ZERO) + "@mail.com")
                .build();
    }


    @Override
    public List<User> createRandomList(int limit) {

        return Stream.generate(UserRandomBuilder::createUser)
                .limit(limit)
                .toList();
    }
}
