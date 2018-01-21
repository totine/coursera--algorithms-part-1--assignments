import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;


    private class Node {
        Item value;
        Node next;
        Node previous;
    }
    /**
     * construct an empty deque
     */
    public Deque() {
        first = null;
        last = null;
    }

    /**
     * is the deque empty?
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * return the number of items on the deque
     */
    public int size() {
        return 0;
    }

    /**
     * add the item to the front
     */
    public void addFirst(Item item) {

    }

    /**
     * add the item to the end
     */
    public void addLast(Item item) {

    }

    /**
     * remove and return the item from the front
     */
    public Item removeFirst() {
        return null;
    }

    /**
     * remove and return the item from the end
     */
    public Item removeLast() {
        return null;
    }

    /**
     * return an iterator over items in order from front to end
     */
    public Iterator<Item> iterator() {
        return null;
    }
}
