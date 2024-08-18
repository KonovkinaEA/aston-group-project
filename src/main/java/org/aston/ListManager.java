package org.aston;

import org.aston.creation.file.FilesReader;
import org.aston.creation.manual.ManualBuilder;
import org.aston.creation.random.RandomCreator;
import org.aston.sorting.Sorter;
import org.aston.usecase.Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListManager<T> {
    private final RandomCreator<T> randomCreator;
    private final FilesReader<T> filesReader;
    private final ManualBuilder<T> manualBuilder;

    private final Sorter<T> sorter;
    private final Search<T> search;

    private List<T> list;

    public ListManager(RandomCreator<T> randomCreator, FilesReader<T> filesReader, ManualBuilder<T> manualBuilder,
                       Sorter<T> sorter, Search<T> search) {
        this.randomCreator = randomCreator;
        this.filesReader = filesReader;
        this.manualBuilder = manualBuilder;
        this.sorter = sorter;
        this.search = search;
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

    public void manualCreation(Scanner scanner, int size) {
        List<T> list = new ArrayList<>();
        int i = 0;
        while (i < size){
            T item = manualBuilder.create(scanner);
            if (item != null) {
                list.add(item);
                i++;
            }
        }

        this.list = list;
    }

    public List<T> sort() {
        list = sorter.sort(list);
        return list;
    }

    public int search(Scanner scanner) {
        T item = null;
        while (item == null) {
            item = manualBuilder.create(scanner);
        }
        return search.search(sorter.sort(list), item);
    }
}
