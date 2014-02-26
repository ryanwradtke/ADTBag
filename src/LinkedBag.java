import java.util.Objects;

/**
 * Bag project based on "Data Structures and Abstractions with Java" by Carrano.
 */

/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 */
public class LinkedBag<T> implements BagInterface<T> {

    private Node root;
    private int numberOfNodes;

    public LinkedBag() {
        root = null;
        numberOfNodes = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfNodes;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        Node tRef = root;

        while ((counter < numberOfNodes) && (tRef != null)) {
            if (anEntry.equals(tRef.getData())) {
                counter++;
            }
            tRef = tRef.next();
        }

        return counter;
    }

    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node tRef = root;

        while (!found && (tRef != null)) {
            if (anEntry.equals(tRef.getData())) {
                found = true;
            } 
            else {
                tRef = tRef.next();
            }
        }

        return tRef;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(T anEntry) {
        return getReferenceTo(anEntry) != null;

    }

    @Override
    public boolean add(T newEntry) {
        //Creates a newNode with newEntry as data and null as .next();
        Node newNode = new Node(newEntry);

        //Sets .next() to root.
        newNode.setNext(root);

        //Sets the root pointer to newNode thereby adding newNode at begining of list.
        root = newNode;

        numberOfNodes++;

        //Always true because no limit on length of linked list!
        return true;
    }

    @Override
    public T remove() {
        // Instantiate tRef as root.
        Node tRef = root;

        //Moves root pointer to the next link.
        root = tRef.next();

        numberOfNodes--;

        //returns tRef.
        return (T) tRef.getData();
    }

    @Override
    public boolean remove(T aObject) {
        boolean removed = false;
        Node tRef = getReferenceTo(aObject);

        if (tRef != null) {
            tRef.setData(root.getData());
            remove();
            removed = true;
        }

        return removed;
    }

    @Override
    public boolean removeAllOf(T aObject) {
        boolean removed = false;
        Node tRef;

        while ((tRef = getReferenceTo(aObject)) != null) {
            tRef.setData(root.getData());
            remove();
            removed = true;
        }

        return removed;
    }

    @Override
    public void empty() {
        root = null;
        numberOfNodes = 0;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[numberOfNodes];

        Node tRef = root;

        for (int i = 0; i < numberOfNodes; i++) {
            array[i] = (T) tRef.getData();
            tRef = tRef.next();
        }

        return array;
    }

    public class Node<T> {

        private T data;
        private Node next;

        private Node(T data) {
            this(data, null);
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T t) {
            this.data = t;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node node) {
            this.next = node;
        }

    }
}
