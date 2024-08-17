package org.aston;

import org.aston.model.Bus;
import org.aston.model.User;
import org.aston.model.Student;
import org.aston.sorting.*;
import org.aston.comparators.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus.Builder()
                .setNumber("123-ABC")
                .setModel("Volvo")
                .setMileage(50000)
                .build();


        User user = new User.Builder()
                .setName("liz(s)a")
                .setPassword("password123")
                .setEmail("lizsa@mail.com")
                .build();

        Student student = new Student.Builder()
                .setGroupNumber("CS-101")
                .setAverageGrade(4.5)
                .setRecordBookNumber("RB123456")
                .build();

        // Check algorithms work
        Bus bus1 = new Bus.Builder()
                .setNumber("123-ABC")
                .setModel("Volvo")
                .setMileage(50000)
                .build();

        Bus bus2 = new Bus.Builder()
                .setNumber("123-ABC")
                .setModel("Volvo")
                .setMileage(900000)
                .build();

        Bus bus3 = new Bus.Builder()
                .setNumber("123-ABC")
                .setModel("Volvo")
                .setMileage(1000)
                .build();

        List<Bus> list = new ArrayList<>();
        list.add(bus1);
        list.add(bus2);
        list.add(bus3);

        Sorter<Bus> sorter = new Sorter<Bus>(new SelectionSort<Bus>());
        List<Bus> result = sorter.sort(list, new BusComparator());
        System.out.println(Arrays.toString(result.toArray()));

//        System.out.println(bus);
//        System.out.println(user);
//        System.out.println(student);
    }
}
