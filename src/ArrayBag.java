/**
 * Bag project based on "Data Structures and Abstractions with Java" by Carrano.
 */
/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 * @param <T>
 */
public class ArrayBag<T> implements BagInterface<T> {

    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    /**
     * ArrayBag constructor takes an integer, capacity, and instantiates
     * variables bag and numberOfEntries.
     *
     * @param capacity
     */
    public ArrayBag(int capacity) {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
    }

    /**
     * Default constructor calls ArrayBag(capacity) with DEFAULT_CAPACITY
     * thereby creating an array with a capacity of 25.
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
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
        return numberOfEntries == bag.length;
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
