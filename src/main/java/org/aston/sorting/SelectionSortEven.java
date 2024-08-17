package org.aston.sorting;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelectionSortEven<T> implements Sorting<T> {
    @Override
    public List<T> sort(List<T> arr, Comparator<T> comparator){
        List<T> sorted = new ArrayList<T>(arr);
        String className = sorted.get(0).getClass().getName();

        try {
            if(className.equals("User"))
                throw new RuntimeException("This class does not support even numbers sorting!");
            else {

                String fieldName;
                switch (className){
                    case "Bus":
                        fieldName = "mileage"; break;
                    case "Student":
                        fieldName = "groupNumber"; break;
                    default:
                        fieldName = "mileage"; break;
                }

                sortCollection(sorted, comparator, fieldName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sorted;
    }

    public void sortCollection(List<T> sorted, Comparator<T> comparator, String fieldName){
        int n = sorted.size();
        boolean[] oddIndexes = new boolean[n];
        try{
            for(int i = 0; i < n - 1; i++){
                if(oddIndexes[i])
                    continue;

                int minIndex = i;
                T minElement = sorted.get(minIndex);
                Field currentElementField = minElement.getClass().getDeclaredField(fieldName);
                int numericField = Integer.parseInt(currentElementField.get(minElement).toString());

                if(numericField%2 != 0)
                    continue;

                for(int j = i + 1; j < n; j++) {
                    if(oddIndexes[j])
                        continue;

                    T comparingElement = sorted.get(j);
                    Field comparingElementFiled = comparingElement.getClass().getDeclaredField(fieldName);
                    numericField = Integer.parseInt(comparingElementFiled.get(comparingElement).toString());

                    if(numericField%2 != 0){
                        oddIndexes[j] = true;
                        continue;
                    }
                    if (comparator.compare(comparingElement, minElement) < 0) {
                        minIndex = j;
                        minElement = sorted.get(minIndex);
                    }
                }
                Collections.swap(sorted, i, minIndex);
            }
        } catch(NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
