package org.aston.creation.random;

import org.aston.model.Student;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

class StudentRandomBuilder implements RandomBuilderInterface{

    private static final double MIN_GRADE = 1;
    private static final double MAX_GRADE = 5;
    private static final int MIN_NUMBER = 100;
    private static final int MAX_NUMBER = 699;
    private static final int MIN_RECORD_BOOK = 1000000;
    private static final int MAX_RECORD_BOOK = 9999999;

    private static double createAverageGrade(){
        return BigDecimal
                .valueOf(RandomBuilderInterface.getRandomNumber(MAX_GRADE, MIN_GRADE))
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private static Student createStudent(){
        return new Student.Builder()
                .setGroupNumber("GN-" + (int)RandomBuilderInterface.getRandomNumber(MAX_NUMBER, MIN_NUMBER))
                .setAverageGrade(createAverageGrade())
                .setRecordBookNumber("RB" + (int)RandomBuilderInterface.getRandomNumber(MAX_RECORD_BOOK, MIN_RECORD_BOOK))
                .build();
    }

    @Override
    public List<Student> createRandomList(int limit) {
        return Stream.generate(StudentRandomBuilder::createStudent)
                .limit(limit)
                .toList();
    }
}
