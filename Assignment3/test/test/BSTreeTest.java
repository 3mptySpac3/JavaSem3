package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.BSTree;
import utilities.Iterator;
import utilities.TreeException;

public class BSTreeTest {

    private BSTree<Integer> tree;

    @BeforeEach
    public void setup() {
        tree = new BSTree<>();
    }

    @Test
    public void testAddAndSearch() throws TreeException {
        assertTrue(tree.isEmpty(), "Tree should be empty initially.");

        tree.add(10);
        tree.add(5);
        tree.add(15);

        assertFalse(tree.isEmpty(), "Tree should not be empty after adding elements.");
        assertNotNull(tree.search(10), "Search should find 10.");
        assertNull(tree.search(100), "Search should not find 100.");
    }

    @Test
    public void testContains() throws TreeException {
        tree.add(10);
        assertTrue(tree.contains(10), "Tree should contain 10.");
        assertFalse(tree.contains(100), "Tree should not contain 100.");
    }

    @Test
    public void testExceptionOnEmptyTree() {
        assertThrows(TreeException.class, () -> tree.getRoot(), "Getting root of empty tree should throw TreeException.");
        assertThrows(TreeException.class, () -> tree.search(10), "Searching in empty tree should throw TreeException.");
    }

    @Test
    public void testClear() {
        tree.add(10);
        tree.clear();
        assertTrue(tree.isEmpty(), "Tree should be empty after clear.");
    }

    @Test
    public void testSize() {
        assertEquals(0, tree.size(), "Size of an empty tree should be 0.");
        tree.add(10);
        tree.add(5);
        tree.add(15);
        assertEquals(3, tree.size(), "Size should be 3 after adding three elements.");
    }

    @Test
    public void testGetHeight() {
        assertEquals(-1, tree.getHeight(), "Height of an empty tree should be -1.");
        tree.add(10);
        tree.add(5);
        tree.add(15);
        assertTrue(tree.getHeight() > 0, "Height should be greater than 0 for a non-empty tree.");
    }

    @Test
    public void testInOrderIterator() {
        tree.add(10);
        tree.add(5);
        tree.add(15);

        Iterator<Integer> iterator = tree.inorderIterator();
        assertTrue(iterator.hasNext(), "Iterator should have next element.");
        assertEquals(5, iterator.next(), "First in-order element should be 5.");
        assertEquals(10, iterator.next(), "Second in-order element should be 10.");
        assertEquals(15, iterator.next(), "Third in-order element should be 15.");
        assertFalse(iterator.hasNext(), "Iterator should have no more elements.");
    }


    @Test
    public void testPreOrderIterator() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);

        Iterator<Integer> iterator = tree.preorderIterator();

        // Assert: check if the elements are iterated in pre-order
        assertTrue(iterator.hasNext(), "Iterator should have next element.");
        assertEquals(10, iterator.next(), "First pre-order element should be 10 (root).");
        assertEquals(5, iterator.next(), "Second pre-order element should be 5 (left child of root).");
        assertEquals(3, iterator.next(), "Third pre-order element should be 3 (left child of 5).");
        assertEquals(7, iterator.next(), "Fourth pre-order element should be 7 (right child of 5).");
        assertEquals(15, iterator.next(), "Fifth pre-order element should be 15 (right child of root).");
        assertFalse(iterator.hasNext(), "Iterator should have no more elements.");
    }



    @Test
    public void testPostOrderIterator() {
        // Arrange: create a tree and add elements
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);

        // Act: create a post-order iterator
        Iterator<Integer> iterator = tree.postorderIterator();

        // Assert: check if the elements are iterated in post-order
        assertTrue(iterator.hasNext(), "Iterator should have next element.");
        assertEquals(3, iterator.next(), "First post-order element should be 3 (left child of 5).");
        assertEquals(7, iterator.next(), "Second post-order element should be 7 (right child of 5).");
        assertEquals(5, iterator.next(), "Third post-order element should be 5 (left child of root).");
        assertEquals(15, iterator.next(), "Fourth post-order element should be 15 (right child of root).");
        assertEquals(10, iterator.next(), "Fifth post-order element should be 10 (root).");
        assertFalse(iterator.hasNext(), "Iterator should have no more elements.");
    }



}
