package org.aston.reader_file.parse;

public  interface RecordParser<T> {
    String getPrefix();
    T parse(String line);
}
