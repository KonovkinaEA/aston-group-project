package org.aston.reader_file;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.aston.model.*;
import org.aston.reader_file.parse.*;
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