
package utilities;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element");
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        if (index == 0) {
            if (head != null) {
                head.prev = newNode;
                newNode.next = head;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            return add(toAdd);
        } else {
            MyDLLNode<E> current = getNodeAt(index);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
        return true;
    }

    // Implement other methods...

    private MyDLLNode<E> getNodeAt(int index) {
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyDLLIterator();
    }

    private class MyDLLIterator implements Iterator<E> {
        private MyDLLNode<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException("No more elements to iterate");
            E data = current.data;
            current = current.next;
            return data;
        }
    }

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) throw new NullPointerException("Cannot add null list");
		
		Iterator<? extends E> iter = toAdd.iterator();
		while (iter.hasNext()) {
			add(iter.next());
		}
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
		return getNodeAt(index).data;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
		
		MyDLLNode<E> toRemove = getNodeAt(index);
		if (toRemove.prev != null) {
			toRemove.prev.next = toRemove.next;
		}else {
			head = toRemove.next;
		}
		if (toRemove.next != null) {
			toRemove.next.prev = toRemove.prev;
		}else {
			tail = toRemove.prev;
		}
		size--;
		return toRemove.data;
		}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) throw new NullPointerException("Cannot remove null element");
		MyDLLNode<E> current = head;
		while (current != null) {
			if (current.data.equals(toRemove)) {
				if (current.prev != null) {
					current.prev.next = current.next;
				} else {
					head = current.next;
				}
				if (current.next != null) {
					current.next.prev = current.prev;
				} else {
					tail = current.prev;
				}
				size--;
				return current.data;
			}
			current = current.next;
		}
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
	    if (toChange == null) throw new NullPointerException("Cannot set null element");
	    if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");

	    MyDLLNode<E> nodeToSet = getNodeAt(index);
	    E oldData = nodeToSet.data;
	    nodeToSet.data = toChange;
	    return oldData;
	 	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
	    if (toFind == null) throw new NullPointerException("Cannot check for null element");
	    MyDLLNode<E> current = head;
	    while (current != null) {
	    	if (current.data.equals(toFind)) {
	    		return true;
	    	}
	    	current = current.next;
	    }
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
	    if (toHold == null) throw new NullPointerException("Provided array cannot be null");
	    if (toHold.length < size) {
	    	toHold = (E[])java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
	    }
	    MyDLLNode<E> current = head;
	    for (int i = 0; i < size; i++) {
	    	toHold[i] = current.data;
	    	current = current.next;
	    }
		return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		MyDLLNode<E> current = head;
		for (int i = 0; i < size; i++) {
			array[i] = current.data;
			current = current.next;
		}
				
		return array;
	}
}

