package org.aston;

import java.util.ArrayList;
import java.util.List;

public class ListManager<T> {

    private final List<T> list;

    public ListManager(Class<T> tClass, int size) {
        this.list = new ArrayList<>(size);
    }

    public void addElement(T element) {
        list.add(element);
    }

    public List<T> getList() {
        return list;
    }
}
