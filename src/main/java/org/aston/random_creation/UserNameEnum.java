package org.aston.random_creation;

import java.util.Arrays;
import java.util.List;

public enum UserNameEnum {

    DENBROUGH("Denbrough"), HANSCOM("Hanscom"), THECLOWN("it"), MARSH("Marsh"), TOZIER("Tozier"),
    URIS("Uris"), HANLON("Hanlon"), KASPBRAK("Kaspbrak"), BOWERS("Bowers"), HOCKSTETTER("Hockstetter")
    ;

    private String name;

    UserNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getAllUserNames(){
        return Arrays.stream(UserNameEnum.values())
                .map(UserNameEnum::getName)
                .toList();
    }
}