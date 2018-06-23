import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;


    private class Node {
        Item value;
        Node next;
        Node previous;

        Node(Item item) {
            value = item;
            next = null;
            previous = null;
        }
    }
    /**
     * construct an empty deque
     */
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * is the deque empty?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the deque
     */
    public int size() {
        return size;
    }

    /**
     * add the item to the front
     */
    public void addFirst(Item item) {
         Node node = new Node(item);
         if (first == null && last == null) {
             first = node;
             last = node;
         }

         else {
             node.next = first;
             first = node;
         }
         size++;
    }

    /**
     * add the item to the end
     */
    public void addLast(Item item) {
        Node node = new Node(item);
        if (first == null && last == null) {
            first = node;
            last = node;
        }

        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    /**
     * remove and return the item from the front
     */
    public Item removeFirst() {
        Item itemToReturn = first.value;
        first = first.next;
        return itemToReturn;
    }

    /**
     * remove and return the item from the end
     */
    public Item removeLast() {
        Item itemToReturn = last.value;
        last = first.previous;
        return itemToReturn;
    }

    /**
     * return an iterator over items in order from front to end
     */
    public Iterator<Item> iterator() {
        return null;
    }
}
