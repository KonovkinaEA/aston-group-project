package org.aston.creation.file;

import org.aston.creation.file.parsers.RecordParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilesReader<T> {
    private final RecordParser<T> parser;

    public FilesReader(RecordParser<T> parser) {
        this.parser = parser;
    }

    public List<T> parseFile(String filePath) {
        List<T> list = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.filter(line -> line.startsWith(parser.getPrefix()))
                    .forEach(line -> list.add(parser.parse(line)));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return list;
    }
}
