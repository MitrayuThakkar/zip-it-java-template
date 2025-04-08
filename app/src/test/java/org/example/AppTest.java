package org.example;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testZipWithIntegers() {
        List<Integer> list1 = List.of(1, 3, 5);
        List<Integer> list2 = List.of(2, 4, 6, 8);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 8);
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    public void testZipWithStrings() {
        List<String> list1 = List.of("A", "B");
        List<String> list2 = List.of("X", "Y", "Z");
        List<String> expected = List.of("A", "X", "B", "Y", "Z");
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    public void testZipWithEmptyList() {
        List<String> list1 = List.of();
        List<String> list2 = List.of("One", "Two");
        List<String> expected = List.of("One", "Two");
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    public void testHashmapifyValid() {
        List<String> keys = List.of("one", "two", "three");
        List<Double> values = List.of(1.1, 2.2, 3.3);
        HashMap<String, Double> result = App.hashmapify(keys, values);
        assertEquals(3, result.size());
        assertEquals(1.1, result.get("one"));
        assertEquals(2.2, result.get("two"));
        assertEquals(3.3, result.get("three"));
    }

    @Test
    public void testHashmapifyThrowsException() {
        List<String> keys = List.of("key1", "key2");
        List<Integer> values = List.of(10);
        assertThrows(IllegalArgumentException.class, () -> {
            App.hashmapify(keys, values);
        });
    }
}
