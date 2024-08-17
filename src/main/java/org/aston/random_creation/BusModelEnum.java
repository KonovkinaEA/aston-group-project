package org.aston.random_creation;

import java.util.Arrays;
import java.util.List;

public enum BusModelEnum {
    PAZIC("Pazic"), VOLVO("Volvo"), MAN("Man"), MERCEDES("Mercedes"), IKARUS("Ikarus"),
    SCANIA("Scania"), AUTOSAN("Autosan"), BYD("BYD"), NEWFLYER("New Flyer"), LIAS("LiAS")
    ;

    private String model;

    BusModelEnum(String model) {
        this.model = model;
    }


    public String getModel() {
        return model;
    }


    public static List<String> getAllModels(){
        return Arrays.stream(BusModelEnum.values())
                .map(BusModelEnum::getModel)
                .toList();
    }
}