package org.aston.creation.file;


import org.aston.creation.file.parsers.BusParser;
import org.aston.creation.file.parsers.RecordParser;
import org.aston.creation.file.parsers.StudentParser;
import org.aston.creation.file.parsers.UserParser;
import org.aston.model.Bus;
import org.aston.model.Student;
import org.aston.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderFiles<T> {

    private final Map<Class<?>, RecordParser<?>> parsers;

    public ReaderFiles() {
        parsers = new HashMap<>();
        parsers.put(Bus.class, new BusParser());
        parsers.put(Student.class, new StudentParser());
        parsers.put(User.class, new UserParser());
    }

    public List<T> readFiles(Class clazz, String filePath) {
        List<T> list = new ArrayList<>();

        RecordParser<T> parser = (RecordParser<T>) parsers.get(clazz);
        if (parser == null) {
            throw new IllegalArgumentException("No parser found for class: " + clazz.getName());
        }

        try {
            Files.lines(Paths.get(filePath))
                    .filter(line -> line.startsWith(parser.getPrefix()))
                    .forEach(line -> list.add(parser.parse(line)));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return list;
    }
}