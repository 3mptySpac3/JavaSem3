package utilities;

import java.util.NoSuchElementException;//When element doesn't exist

public class MyQueue<T> implements QueueADT<T> {

    private Node<T> front; // front of the queue (head)
    private Node<T> rear;  // end of the queue (tail)
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T element = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // the queue is now empty
        }
        size--;
        return element;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

}
