package org.aston.creation.file.parsers;

import org.aston.model.Student;

public class StudentParser implements RecordParser<Student> {
    @Override
    public String getPrefix() {
        return "Student";
    }

    @Override
    public Student parse(String line) {
        line = line.replace("Student = ", "");
        String[] parts = line.split(",");
        return new Student.Builder()
                .setGroupNumber(parts[0].trim())
                .setAverageGrade(Double.parseDouble(parts[1].trim()))
                .setRecordBookNumber(parts[2].trim())
                .build();
    }
}
