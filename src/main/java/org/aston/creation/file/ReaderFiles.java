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
import java.util.function.Function;

public class ReaderFiles {

    private final Map<String, Function<String, List<?>>> parsers;

    public ReaderFiles() {
        parsers = new HashMap<>();
        parsers.put(Bus.class.getName(), filePath -> parseFile(new BusParser(), filePath));
        parsers.put(Student.class.getName(), filePath -> parseFile(new StudentParser(), filePath));
        parsers.put(User.class.getName(), filePath -> parseFile(new UserParser(), filePath));
    }

    public List<?> readFiles(String clazzName, String filePath) {
        Function<String, List<?>> parserFunction = parsers.get(clazzName);
        if (parserFunction == null) {
            throw new IllegalArgumentException("No parser found for class: " + clazzName);
        }

        return parserFunction.apply(filePath);
    }

    private <T> List<T> parseFile(RecordParser<T> parser, String filePath) {
        List<T> list = new ArrayList<>();

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
