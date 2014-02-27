
import java.util.Objects;

/**
 * Bag project based on "Data Structures and Abstractions with Java" by Carrano.
 */
/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 */
public class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode;
    private int numberOfNodes;

    public LinkedBag() {
        firstNode = null;
        numberOfNodes = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfNodes;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        Node tRef = firstNode;

        //iterates list until list ends, counting number of matching objects.
        while ((counter < numberOfNodes) && (tRef != null)) {
            if (anEntry.equals(tRef.data)) {
                counter++;
            }
            tRef = tRef.next;
        }

        return counter;
    }

    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node tRef = firstNode;

        //iterates list untill object is found or list ends.
        while (!found && (tRef != null)) {
            if (anEntry.equals(tRef.data)) {
                found = true;
            } else {
                tRef = tRef.next;
            }
        }

        return tRef;
    }

    @Override
    public boolean isFull() {
        //Never full!
        return false;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public boolean contains(T anEntry) {
        //true if getReferenceTo returns an object.
        return getReferenceTo(anEntry) != null;

    }

    @Override
    public boolean add(T newEntry) {
        /**
         * Points firstNode to a new Node that has data(newEntry) and
         * next(firstNode).
         */
        firstNode = new Node(newEntry, firstNode);

        numberOfNodes++;

        //Always true because no limit on length of linked list!
        return true;
    }

    @Override
    public T remove() {
        // Instantiate tRef as root.
        Node tRef = firstNode;

        //Moves root pointer to the next link.
        firstNode = tRef.next;

        numberOfNodes--;

        //returns tRef.
        return (T) tRef.data;
    }

    @Override
    public boolean remove(T aObject) {
        boolean removed = false;
        Node tRef = getReferenceTo(aObject);

        //if getReferenceTo returns an object, remove that object.
        if (tRef != null) {
            tRef.data = firstNode.data;
            remove();
            removed = true;
        }

        return removed;
    }

    @Override
    public boolean removeAllOf(T aObject) {
        boolean removed = false;
        Node tRef;
        
        //while getReferenceTo returns an object, remove that object.
        while ((tRef = getReferenceTo(aObject)) != null) {
            tRef.data = firstNode.data;
            remove();
            removed = true;
        }

        return removed;
    }

    @Override
    public void empty() {
        firstNode = null;
        numberOfNodes = 0;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[numberOfNodes];

        Node tRef = firstNode;
        
        //Iterates the linked list; fills the array with data from each node.
        for (int i = 0; i < numberOfNodes; i++) {
            array[i] = (T) tRef.data;
            tRef = tRef.next;
        }

        return array;
    }

    //private inner class Node.  LinkedBag is the only class that uses Node.
    private class Node<T> {

        private T data;
        private Node next;

        private Node(T data) {
            this(data, null);
        }

        //Second constructor makes that add() method of LinkedBag simpler.
        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
