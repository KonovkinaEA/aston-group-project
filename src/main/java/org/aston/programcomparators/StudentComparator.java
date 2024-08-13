package org.aston.programcomparators;

import org.aston.model.Student;
import java.util.Comparator;

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2){
        if(s1.getGroupNumber().compareTo(s2.getGroupNumber()) < 0) {
            return -1;
        } else if(s1.getGroupNumber().compareTo(s2.getGroupNumber()) == 0) {
            if(s1.getAverageGrade() < s2.getAverageGrade()) {
                return -1;
            } else if(s1.getAverageGrade() == s2.getAverageGrade()) {
                if(s1.getRecordBookNumber().compareTo(s2.getRecordBookNumber()) < 0){
                    return -1;
                } else if(s1.getRecordBookNumber().compareTo(s2.getRecordBookNumber()) == 0){
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


