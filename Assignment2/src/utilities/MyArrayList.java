package utilities;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class MyArrayList<E> implements ListADT<E> {

    private static final long serialVersionUID = -6641976547739553233L;
    private E[] data; // Internal array to store the list elements
    private int size; // Number of elements in the list

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        data = (E[]) new Object[10]; // Initial capacity of 10
        size = 0;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            E[] newData = (E[]) new Object[2 * data.length];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element");
        ensureCapacity();
        data[size++] = toAdd;
        return true;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");

        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = toAdd;
        size++;
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        return data[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        
        E element = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        data[size] = null; // Help with garbage collection
        return element;
    }

    // Other methods (size, clear, isEmpty, etc.) remain unchanged

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException("No more elements to iterate");
            return data[currentIndex++];
        }
    }

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
	    if (toAdd == null) throw new NullPointerException("Cannot add null list");
	    
	    Iterator<? extends E> iter = toAdd.iterator();
	    while (iter.hasNext()) {
	        add(iter.next());
	    }
	    return true;
	}
	

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) throw new NullPointerException("Cannot remove null element");
		for (int i = 0; i < size; i++) {
			if (data[i].equals(toRemove)) {
				return remove(i);
			}
		}
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) throw new NullPointerException("Cannot set null element");
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
		E oldElement = data[index];
		data[index] = toChange;
		return oldElement;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) throw new NullPointerException("Cannot check for null element");
		for (int i = 0; i < size; i++) {
			if (data[i].equals(toFind)) {
				return true;
			}
		}
		return false;
	}

	
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
	    if (toHold == null) throw new NullPointerException("Provided array cannot be null");
	    if (toHold.length < size) {
	        toHold = (E[])java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
	    }
	    System.arraycopy(data, 0, toHold, 0, size);
	    if (toHold.length > size) {
	        toHold[size] = null;
	    }
	    return toHold;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size);
	}
}

