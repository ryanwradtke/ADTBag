
/**
 * Bag project based on "Data Structures and Abstractions with Java" by Carrano.
 */
/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 * @param <T>
 */
public interface BagInterface<T> {

    /**
     * getCurrentSize() returns the number of items currently in the bag.
     *
     * @return integer.
     */
    int getCurrentSize();

    /**
     * quantOf() first checks !isEmpty() and then takes a String type and calls
     * containsType() to check if type occurs in bag. Returns the quantity type
     * specific occurrences.
     *
     * @param t@return
     */
    int getFrequencyOf(T t);

    /**
     * isFull() checks to see if bag is full.
     *
     * @return boolean
     */
    boolean isFull();

    /**
     * isEmpty() checks to see if the bag is empty.
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * contains(T) first checks that !isEmpty() and then checks whether a
     * specified type exists in bag and returns a boolean.
     *
     * @param t
     * @return
     */
    boolean contains(T t);

    /**
     * add(T) takes an object, checks !isFull(). If full: prints "full". If not
     * full: adds the object to the bag.
     *
     * @param t
     * @return
     */
    boolean add(T t);

    /**
     * remove() removes the last added entry from the bag.
     *
     * @return
     */
    T remove();

    /**
     * remove(T) removes one entry of a given type from the ADT.
     *
     * @param t
     * @return
     */
    boolean remove(T t);

    /**
     * removeAllOf(T t) removes all entries of a given type
     *
     * @param t
     * @return
     */
    boolean removeAllOf(T t);

    /**
     * Will empty the bag.
     */
    void empty();

    /**
     * listContents() first checks !isEmpty(). if isEmpty() prints that bag is
     * empty. If !isEmpty, returns an array of the objects in the bag.
     *
     * @return
     */
    T[] toArray();

}
