package org.aston.usecase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.aston.model.Bus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
  private static SearchUseCase<Bus> searchUseCase;

  @BeforeAll
  public static void init() {
    List<Bus> sortedList = new ArrayList<>();
    Bus bus = new Bus.Builder()
        .setNumber("211-NDJ")
        .setModel("Wakd")
        .setMileage(203)
        .build();
    Bus bus0 = new Bus.Builder()
        .setNumber("123-ABC")
        .setModel("Volvo")
        .setMileage(200)
        .build();
    Bus bus1 = new Bus.Builder()
        .setNumber("231-MVW")
        .setModel("Cam")
        .setMileage(100)
        .build();
    sortedList.add(bus0);
    sortedList.add(bus);
    sortedList.add(bus1);
    searchUseCase = new BinarySearchUseCase<>(sortedList);
  }

  @Test
  public void test() {
    Bus busForSearch = new Bus.Builder()
        .setNumber("231-MVW")
        .setModel("Cam")
        .setMileage(100)
        .build();
    Comparator<Bus> busComparator = Comparator.comparing(Bus::getNumber);
    Assertions.assertEquals(2, searchUseCase.search(busForSearch, busComparator));
  }

  @Test
  public void testSearchUnExistingElement() {
    Bus busForSearch = new Bus.Builder()
        .setNumber("23qw-MVW")
        .setModel("Cam")
        .setMileage(100)
        .build();
    Comparator<Bus> busComparator = Comparator.comparing(Bus::getNumber);
    Assertions.assertTrue(searchUseCase.search(busForSearch, busComparator) < 0);
  }

  @Test
  public void testSearchInNotSortedList() {
    Bus busForSearch = new Bus.Builder()
        .setNumber("123-ABC")
        .setModel("Cam")
        .setMileage(100)
        .build();
    Comparator<Bus> busComparator = Comparator.comparing(Bus::getNumber);

    List<Bus> sortedList = new ArrayList<>();
    Bus bus0 = new Bus.Builder()
        .setNumber("123-ABC")
        .setModel("Volvo")
        .setMileage(200)
        .build();
    Bus bus1 = new Bus.Builder()
        .setNumber("231-MVW")
        .setModel("Cam")
        .setMileage(100)
        .build();
    Bus bus2 = new Bus.Builder()
        .setNumber("211-NDJ")
        .setModel("Wakd")
        .setMileage(203)
        .build();
    sortedList.add(bus0);
    sortedList.add(bus1);
    sortedList.add(bus2);
    searchUseCase = new BinarySearchUseCase<>(sortedList);
    Assertions.assertTrue(searchUseCase.search(busForSearch, busComparator) < 0);
  }
}
