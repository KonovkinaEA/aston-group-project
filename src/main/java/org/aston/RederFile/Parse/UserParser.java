package org.aston.RederFile.Parse;
import org.aston.model.User;

public class UserParser implements RecordParser<User> {
    @Override
    public String getPrefix() {
        return "User";
    }

    @Override
    public User parse(String line) {
        String[] parts = line.split(",");
        return new User.Builder()
                .setName(parts[0].trim())
                .setPassword(parts[1].trim())
                .setEmail(parts[2].trim())
                .build();
    }
}
