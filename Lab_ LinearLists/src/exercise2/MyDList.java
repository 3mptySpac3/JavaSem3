package exercise2;

import java.util.NoSuchElementException;

// Class for doubly linked list
public class MyDList<E> {
    // Reference to the first node in the list
    public MyNode<E> head;
    // Reference to the last node in the list
    public MyNode<E> tail;
    // The size of the list (number of elements)
    public int size;
    
    // Constructor to create an empty list
    public MyDList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    // Method to add an element at the beginning of the list
    public void addFirst(E item) {
        // Create a new node. The new node's next reference is the current head
        MyNode<E> newNode = new MyNode<>(item, head, null);
        if (head != null) {
            // If the list isn't empty, set the current head's prev reference to the new node
            head.prev = newNode;
        } else {
            // If the list is empty, set the tail to the new node as well
            tail = newNode; 
        }
        // The new node becomes the new head
        head = newNode;
        // Increase the list size
        size++;
    }
    
    // Method to add an element at the end of the list
    public void addLast(E item) {
        // Create a new node. The new node's prev reference is the current tail
        MyNode<E> newNode = new MyNode<>(item, null, tail);
        if (tail != null) {
            // If the list isn't empty, set the current tail's next reference to the new node
            tail.next = newNode;
        } else {
            // If the list is empty, set the head to the new node as well
            head = newNode; 
        }
        // The new node becomes the new tail
        tail = newNode;
        // Increase the list size
        size++;
    }
    
    // Method to remove and return the first element of the list
    public E removeFirst() {
        if (head == null) {
            // If the list is empty, throw an exception
            throw new NoSuchElementException("Cannot remove from an empty list");
        }
        // Store the item to return
        E item = head.item;
        // Move the head reference to the next node
        head = head.next;
        if (head != null) {
            // If the list isn't now empty, remove the previous reference from the new head
            head.prev = null;
        } else {
            // If the list is now empty, also set the tail to null
            tail = null;
        }
        // Decrease the list size
        size--;
        // Return the removed item
        return item;
    }
    
    // Method to remove and return the last element of the list
    public E removeLast() {
        if (tail == null) {
            // If the list is empty, throw an exception
            throw new NoSuchElementException("Cannot remove from an empty list");
        }
        // Store the item to return
        E item = tail.item;
        // Move the tail reference to the previous node
        tail = tail.prev;
        if (tail != null) {
            // If the list isn't now empty, remove the next reference from the new tail
            tail.next = null;
        } else {
            // If the list is now empty, also set the head to null
            head = null;
        }
        // Decrease the list size
        size--;
        // Return the removed item
        return item;
    }
    
    // Method to get the size of the list
    public int size() {
        return size;
    }
    
    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }
}
