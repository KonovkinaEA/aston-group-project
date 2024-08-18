package org.aston.creation.file.parsers;

public interface RecordParser<T> {
    String getPrefix();
    T parse(String line);
}
