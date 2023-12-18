package utilities;
import java.io.Serializable;

/**
 * Node class for a binary search tree (BST).
 *
 * @param <T> the type of the value stored in the node
 */
public class BSTreeNode<T> implements Serializable {
	 private static final long serialVersionUID = 1L;
    private T data; // The data contained within the node
    private BSTreeNode<T> left; // The left child of the node
    private BSTreeNode<T> right; // The right child of the node


    public BSTreeNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }


    public BSTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public BSTreeNode<T> getLeft() {
        return left;
    }


    public void setLeft(BSTreeNode<T> left) {
        this.left = left;
    }

    public BSTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BSTreeNode<T> right) {
        this.right = right;
    }
}