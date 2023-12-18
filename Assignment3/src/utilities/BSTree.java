package utilities;

import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {

	private static final long serialVersionUID = 1L;
	private BSTreeNode<E> root;

    // Constructor
    public BSTree() {
        root = null;
    }

    @Override
    public BSTreeNode<E> getRoot() throws TreeException {
        if (root == null) {
            throw new TreeException("The tree is empty.");
        }
        return root;
    }


    @Override
    public int getHeight() {
        return getHeightRecursive(root);
    }

    private int getHeightRecursive(BSTreeNode<E> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeightRecursive(node.getLeft()), getHeightRecursive(node.getRight()));
    }

    @Override
    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(BSTreeNode<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight());
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean contains(E entry) throws TreeException {
        return search(entry) != null;
    }

    public BSTreeNode<E> search(E entry) throws TreeException {
        if (root == null) {
            throw new TreeException("The tree is empty.");
        }
        return searchRecursive(root, entry);
    }



    private BSTreeNode<E> searchRecursive(BSTreeNode<E> node, E entry) {
        if (node == null) {
            return null;
        }
        int comparisonResult = entry.compareTo(node.getData());
        if (comparisonResult == 0) {
            // Entry found.
            return node;
        } else if (comparisonResult < 0) {
            // Continue search in the left subtree.
            return searchRecursive(node.getLeft(), entry);
        } else {
            // Continue search in the right subtree.
            return searchRecursive(node.getRight(), entry);
        }
    }


    @Override
    public boolean add(E newEntry) {
        root = addRecursive(root, newEntry);
        return root != null; // If the root is not null, the addition was successful
    }

    private BSTreeNode<E> addRecursive(BSTreeNode<E> node, E entry) {
        if (node == null) {
            return new BSTreeNode<>(entry);
        }
        if (entry.compareTo(node.getData()) < 0) {
            node.setLeft(addRecursive(node.getLeft(), entry));
        } else if (entry.compareTo(node.getData()) > 0) {
            node.setRight(addRecursive(node.getRight(), entry));
        } else {
            // value already exists
            return node;
        }
        return node;
    }

    private class InOrderIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> stack = new Stack<>();

        private InOrderIterator(BSTreeNode<E> root) {
            pushLeft(root);
        }

        private void pushLeft(BSTreeNode<E> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the tree.");
            }
            BSTreeNode<E> node = stack.pop();
            pushLeft(node.getRight());
            return node.getData();
        }
    }

    private class PreOrderIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> stack = new Stack<>();

        private PreOrderIterator(BSTreeNode<E> root) {
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the tree.");
            }
            BSTreeNode<E> node = stack.pop();
            // Push right first so that left is processed first
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            return node.getData();
        }
    }


    private class PostOrderIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> stack = new Stack<>();
        private BSTreeNode<E> lastVisited = null;

        private PostOrderIterator(BSTreeNode<E> root) {
            pushLeftmost(root);
        }

        private void pushLeftmost(BSTreeNode<E> node) {
            while (node != null) {
                stack.push(node);
                if (node.getLeft() != null) {
                    node = node.getLeft();
                } else {
                    node = node.getRight();
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the tree.");
            }
            while (hasNext()) {
                BSTreeNode<E> current = stack.peek();

                // If right child exists and traversing node from left child, then move right
                if (current.getRight() != null && lastVisited != current.getRight()) {
                    pushLeftmost(current.getRight());
                } else {
                    stack.pop();
                    lastVisited = current;
                    return current.getData();
                }
            }
            throw new NoSuchElementException();
        }
    }



    @Override
    public Iterator<E> inorderIterator() {
        return new InOrderIterator(root);
    }

    @Override
    public Iterator<E> preorderIterator() {
        return new PreOrderIterator(root);
    }

    @Override
    public Iterator<E> postorderIterator() {
        return new PostOrderIterator(root);
    }
    
 

    
}
