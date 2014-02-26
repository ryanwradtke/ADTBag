import java.util.Arrays;

/**
 * Bag project based on "Data Structures and Abstractions with Java" by Carrano.
 */
/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 * @param <T>
 */
public class ResizableArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    /**
     * Default constructor calls ResizableArrayBag(capacity) with
     * DEFAULT_CAPACITY thereby creating an array with a capacity of 25.
     */
    public ResizableArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * ResizableArrayBag constructor takes an integer, capacity, and
     * instantiates variables bag and numberOfEntries.
     *
     * @param capacity
     */
    public ResizableArrayBag(int capacity) {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
    }

    /**
     * ResizableArrayBag(T[] contents) instantiates bag to T[] contents.
     *
     * @param contents
     */
    public ResizableArrayBag(T[] contents) {
        bag = Arrays.copyOf(contents, contents.length);
        numberOfEntries = contents.length;
    }

    public void ensureCapacity() {
        if (numberOfEntries == bag.length) {
            bag = Arrays.copyOf(bag, 2 * bag.length);
        }
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;

        for (int index = 0; index < numberOfEntries; index++) {
            if (bag[index].equals(anEntry)) {
                counter++;
            }
        }

        return counter;
    }

    public int getIndexOf(T anEntry) {
        int index = 0;

        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isFull() {
        return false; //Resizable is never full!
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean wasFound = false;
        int index = 0;
        while (!wasFound && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                wasFound = true;
            } else {
                index++;
            }
        }
        return wasFound;
    }

    @Override
    public boolean add(T anEntry) {
        ensureCapacity();

        boolean result = true;
        if (isFull()) {
            result = false;
        } else {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
        }
        return result;
    }

    @Override
    public T remove() {
        return removeEntry(numberOfEntries - 1);
    }

    @Override
    public boolean remove(T anEntry) {
        boolean removed = false;
        int index;

        //Tests if anEntry exists in bag and removes the first one it finds.
        if ((index = getIndexOf(anEntry)) != -1) {
            removeEntry(index);
            removed = true;
        }

        return removed;
    }

    @Override
    public boolean removeAllOf(T anEntry) {
        boolean removed = false;
        int index;

        //Tests if anEntry exists in bag and removes the each one it finds.
        while ((index = getIndexOf(anEntry)) != -1) {
            removeEntry(index);
            removed = true;
        }

        return removed;
    }

    public T removeEntry(int index) {
        numberOfEntries--;
        T removed = bag[index];
        bag[index] = bag[numberOfEntries];
        return removed;
    }

    @Override
    public void empty() {
        for (T item : bag) {
            item = null;
        }
        numberOfEntries = 0;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
        System.arraycopy(bag, 0, result, 0, numberOfEntries);

        return result;
    }
}
