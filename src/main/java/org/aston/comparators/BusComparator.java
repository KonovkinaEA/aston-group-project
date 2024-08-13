package org.aston.comparators;

import org.aston.model.Bus;
import java.util.Comparator;

public class BusComparator implements Comparator<Bus> {
    @Override
    public int compare(Bus b1, Bus b2){
        int numberComparison = b1.getNumber().compareTo(b2.getNumber());
        if (numberComparison != 0) {
            return numberComparison;
        }

        int modelComparison = b1.getModel().compareTo(b2.getModel());
        if (modelComparison != 0) {
            return modelComparison;
        }

        return Integer.compare(b1.getMileage(), b2.getMileage());
    }
}
