package Jtest;

import utilities.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class MyQueueTests {

    private MyQueue<Integer> queue;

    @BeforeEach
    void setup() {
        queue = new MyQueue<>();
    }

    @Test
    void testQueueIsEmptyInitially() {
        assertTrue(queue.isEmpty(), "Queue should be empty initially");
    }

    @Test
    void testEnqueueIncreasesSize() {
        queue.enqueue(10);
        assertEquals(1, queue.size(), "Queue size should be 1 after enqueue");
    }

    @Test
    void testDequeueReturnsCorrectElement() {
        queue.enqueue(20);
        assertEquals(20, queue.dequeue(), "Dequeue should return the first enqueued element");
    }

    @Test
    void testDequeueEmptyQueueThrowsException() {
        assertThrows(NoSuchElementException.class, () -> queue.dequeue(), "Dequeue on empty queue should throw NoSuchElementException");
    }

    @Test
    void testFirstReturnsCorrectElement() {
        queue.enqueue(30);
        queue.enqueue(40);
        assertEquals(30, queue.first(), "First should return the first enqueued element without removing it");
    }

    @Test
    void testFirstEmptyQueueThrowsException() {
        assertThrows(NoSuchElementException.class, () -> queue.first(), "First on empty queue should throw NoSuchElementException");
    }

    @Test
    void testIsEmptyAfterClear() {
        queue.enqueue(50);
        queue.clear();
        assertTrue(queue.isEmpty(), "Queue should be empty after clear");
    }

    @Test
    void testSizeReflectsQueueContent() {
        queue.enqueue(60);
        queue.enqueue(70);
        assertEquals(2, queue.size(), "Queue size should reflect the number of enqueued elements");
        queue.dequeue();
        assertEquals(1, queue.size(), "Queue size should decrease after dequeue");
    }

    @Test
    void testOrderOfElements() {
        queue.enqueue(80);
        queue.enqueue(90);
        assertEquals(80, queue.dequeue(), "Queue should follow FIFO order");
        assertEquals(90, queue.dequeue(), "Queue should follow FIFO order");
    }
}