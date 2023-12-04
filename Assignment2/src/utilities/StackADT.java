package utilities;

public interface StackADT<T> {
	/**
	 * <p>
	 * The <code>ListADT</code> interface is designed to be used as a basis for all
	 * the Linear data structures that will be developed in the CPRG 311 class at 
	 * SAIT. The implementors of this interface will be required to add all the 
	 * functionality.
	 * </p>
	 * 
	 * @param <E> The type of elements this list holds.
	 */

    void push(T element); // Adds an element to the top of the stack

    T pop(); // Removes and returns the top element from the stack

    T peek(); // Returns the top element without removing it from the stack

    boolean isEmpty(); // Returns true if the stack is empty

    int size(); // Returns the number of elements in the stack

}
