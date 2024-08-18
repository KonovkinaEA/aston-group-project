package org.aston.creation.manual;

import java.util.Scanner;

public interface ManualBuilder<T> {
    T create(Scanner scanner);
}
