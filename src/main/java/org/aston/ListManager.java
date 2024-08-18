package org.aston;

import org.aston.creation.file.FilesReader;
import org.aston.creation.random.RandomCreator;

import java.util.Collections;
import java.util.List;

public class ListManager<T> {
    private final RandomCreator<T> randomCreator;
    private final FilesReader<T> filesReader;

    private List<T> list;

    public ListManager(RandomCreator<T> randomCreator, FilesReader<T> filesReader) {
        this.randomCreator = randomCreator;
        this.filesReader = filesReader;
        this.list = Collections.emptyList();
    }

    public List<T> getList() {
        return list;
    }

    public List<T> generateRandomList(int size) {
        list = randomCreator.getRandomList(size);
        return list;
    }

    public List<T> readListFromFile(String filePath) {
        list = filesReader.parseFile(filePath);
        return list;
    }
}
