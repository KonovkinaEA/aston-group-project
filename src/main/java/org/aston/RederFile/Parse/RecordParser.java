package org.aston.RederFile.Parse;

public  interface RecordParser<T> {
    String getPrefix();
    T parse(String line);
}
