package org.aston.comparators;

import org.aston.model.Bus;
import java.util.Comparator;

public class BusComparator implements Comparator<Bus> {
    @Override
    public int compare(Bus b1, Bus b2){
        if(b1.getNumber().compareTo(b2.getNumber()) < 0) {
            return -1;
        } else if(b1.getNumber().compareTo(b2.getNumber()) == 0) {
            if(b1.getModel().compareTo(b2.getModel()) < 0) {
                return -1;
            } else if(b1.getModel().compareTo(b2.getModel()) == 0) {
                if(b1.getMileage() < b2.getMileage()){
                    return -1;
                } else if(b1.getMileage() == b2.getMileage()){
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
