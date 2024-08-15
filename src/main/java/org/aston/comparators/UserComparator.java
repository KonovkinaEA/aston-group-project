package org.aston.comparators;

import org.aston.model.User;
import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2){
        int numberComparison = u1.getName().compareTo(u2.getName());
        if (numberComparison != 0) {
            return numberComparison;
        }

        int modelComparison = u1.getPassword().compareTo(u2.getPassword());
        if (modelComparison != 0) {
            return modelComparison;
        }

        return u1.getEmail().compareTo(u2.getEmail());
    }
}
