package exercise2;

public class MyNode<E> {
	public E item;
	public MyNode<E> next;
	public MyNode<E> prev;
	
	public MyNode(E item, MyNode<E> next, MyNode<E> prev) {
		this.item = item;
		this.next = next;
		this.prev = prev;
	}
	
	public E getItem() {
        return item;
    }

    public MyNode<E> getNext() {
        return next;
    }

    public MyNode<E> getPrev() {
        return prev;
    }

}
