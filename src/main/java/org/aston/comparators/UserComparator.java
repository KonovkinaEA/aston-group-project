package org.aston.comparators;

import org.aston.model.User;
import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2){
        if(u1.getName().compareTo(u2.getName()) < 0) {
            return -1;
        } else if(u1.getName().compareTo(u2.getName()) == 0) {
            if(u1.getPassword().compareTo(u2.getPassword()) < 0) {
                return -1;
            } else if(u1.getPassword().compareTo(u2.getPassword()) == 0) {
                if(u1.getEmail().compareTo(u2.getEmail()) < 0){
                    return -1;
                } else if(u1.getEmail().compareTo(u2.getEmail()) == 0){
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
