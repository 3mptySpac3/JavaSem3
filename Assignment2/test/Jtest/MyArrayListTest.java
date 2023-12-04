package Jtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyArrayList;

import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;



class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void testSizeAndIsEmpty() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        list.add(1);
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void testAddAndGet() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testAddAtIndex() {
        list.add(0, 1);
        list.add(1, 3);
        list.add(1, 2);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testRemoveAtIndex() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.remove(1));
        assertEquals(1, list.size());
    }

    @Test
    void testRemoveElement() {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertFalse(list.contains(1));
    }

    @Test
    void testSet() {
        list.add(1);
        assertEquals(1, list.set(0, 2));
        assertEquals(2, list.get(0));
    }

    @Test
    void testContains() {
        list.add(1);
        assertTrue(list.contains(1));
        assertFalse(list.contains(2));
    }

    @Test
    void testToArray() {
        list.add(1);
        list.add(2);
        Object[] arr = list.toArray();
        assertArrayEquals(new Object[]{1, 2}, arr);
    }

    @Test
    void testToArrayWithType() {
        list.add(1);
        list.add(2);
        Integer[] arr = new Integer[2];
        arr = list.toArray(arr);
        assertArrayEquals(new Integer[]{1, 2}, arr);
    }

    @Test
    void testAddAll() {
        MyArrayList<Integer> newList = new MyArrayList<>();
        newList.add(1);
        newList.add(2);
        list.addAll(newList);
        assertEquals(2, list.size());
    }

    // Exception testing
    @Test
    void testAddNull() {
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    void testAddAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 10));
    }

    @Test
    void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
}
