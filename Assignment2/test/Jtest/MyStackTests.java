package Jtest;

import utilities.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class MyStackTests {

    private MyStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack<>();
    }

    @Test
    void testStackIsEmptyInitially() {
        assertTrue(stack.isEmpty(), "Stack should be empty initially");
    }

    @Test
    void testPushIncreasesSize() {
        stack.push(10);
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
        assertEquals(1, stack.size(), "Stack size should be 1 after one push");
    }

    @Test
    void testPopReturnsCorrectElement() {
        stack.push(20);
        assertEquals(20, stack.pop(), "Pop should return the last pushed element");
        assertTrue(stack.isEmpty(), "Stack should be empty after popping the only element");
    }

    @Test
    void testPopEmptyStackThrowsException() {
        assertThrows(IllegalStateException.class, () -> stack.pop(), "Pop on empty stack should throw IllegalStateException");
    }

    @Test
    void testPeekReturnsCorrectElementWithoutRemoving() {
        stack.push(30);
        assertEquals(30, stack.peek(), "Peek should return the last pushed element without removing it");
        assertEquals(1, stack.size(), "Stack size should not change after peek");
    }

    @Test
    void testPeekEmptyStackThrowsException() {
        assertThrows(IllegalStateException.class, () -> stack.peek(), "Peek on empty stack should throw IllegalStateException");
    }

    @Test
    void testSizeReflectsStackContent() {
        stack.push(40);
        stack.push(50);
        assertEquals(2, stack.size(), "Stack size should reflect the number of pushed elements");
        stack.pop();
        assertEquals(1, stack.size(), "Stack size should decrease after pop");
    }

    @Test
    void testOrderOfElements() {
        stack.push(60);
        stack.push(70);
        assertEquals(70, stack.pop(), "Stack should follow LIFO order");
        assertEquals(60, stack.pop(), "Stack should follow LIFO order");
    }
}
