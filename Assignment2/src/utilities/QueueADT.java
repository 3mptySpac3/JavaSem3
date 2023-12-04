package utilities;

public interface QueueADT<T> {
	
    void enqueue(T element);  // Add an element to the end of the queue

    T dequeue();             // Remove and return the front element of the queue

    T first();               // Peek at the front element without removing it

    boolean isEmpty();       // Check if the queue is empty

    int size();              // Get the number of elements in the queue

    void clear();            // Clear the queue

}
