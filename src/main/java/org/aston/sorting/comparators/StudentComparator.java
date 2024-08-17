package org.aston.sorting.comparators;

import org.aston.model.Student;

import java.util.Comparator;

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2){
        int numberComparison = s1.getGroupNumber().compareTo(s2.getGroupNumber());
        if (numberComparison != 0) {
            return numberComparison;
        }

        int modelComparison = Double.compare(s1.getAverageGrade(), s2.getAverageGrade());
        if (modelComparison != 0) {
            return modelComparison;
        }

        return s1.getRecordBookNumber().compareTo(s2.getRecordBookNumber());
    }
}


