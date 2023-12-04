package Jtest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Iterator;
import utilities.MyDLL;

import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;



class MyDLLTests {

    private MyDLL<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyDLL<>();
    }

    @Test
    void testAddAndGet() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testAddAtIndex() {
        list.add(0, 10);
        list.add(1, 30);
        list.add(1, 20);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testClear() {
        list.add(10);
        list.add(20);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveAtIndex() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveElement() {
        list.add(10);
        list.add(20);
        list.add(30);
//        assertTrue(list.remove(Integer.valueOf(20)));
        list.remove(1);
        assertEquals(2, list.size());
        assertFalse(list.contains(20));
    }

    @Test
    void testSet() {
        list.add(10);
        list.add(20);
        assertEquals(20, list.set(1, 30));
        assertEquals(30, list.get(1));
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(10);
        assertFalse(list.isEmpty());
    }

    @Test
    void testContains() {
        list.add(10);
        list.add(20);
        assertTrue(list.contains(10));
        assertFalse(list.contains(30));
    }

    @Test
    void testToArray() {
        list.add(10);
        list.add(20);
        Object[] arr = list.toArray();
        assertArrayEquals(new Object[]{10, 20}, arr);
    }

    @Test
    void testToArrayWithType() {
        list.add(10);
        list.add(20);
        Integer[] arr = new Integer[2];
        arr = list.toArray(arr);
        assertArrayEquals(new Integer[]{10, 20}, arr);
    }

    @Test
    void testIterator() {
        list.add(10);
        list.add(20);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorNoSuchElementException() {
        list.add(10);
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testAddAll() {
        MyDLL<Integer> newList = new MyDLL<>();
        newList.add(10);
        newList.add(20);
        list.addAll(newList);
        assertEquals(2, list.size());
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    // Tests for handling exceptions
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
