/**
 * Bag project based on "Data Structures and Abstractions with Java" by Carrano.
 */
/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 */
public class BagTest {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        String[] testSet = {"a", "b", "c", "d", "c"};

        /**
         * test1 is instantiated as a new ArrayBag with the default capacity.
         */
        BagInterface bag1 = new LinkedBag();

        /**
         * test2 is instantiated as a new ArrayBag with a custom capacity of 10.
         */
        BagInterface bag2 = new LinkedBag();

        /**
         * test3 is instantiated as a new ResizableArrayBag with default
         * capacity.
         */
        BagInterface bag3 = new ResizableArrayBag();

        /**
         * Validate that the array bags are empty by calling showBagStatus.
         */
        System.out.println("\nTesting isEmpty().");

        System.out.println("Bag 1:");
        showBagStatus(bag1);

        System.out.println("Bag 2:");
        showBagStatus(bag2);

        /**
         * Adding items to each bag, testing the boolean and printing the result
         * to screen. Then testing the status to make sure the items are
         * present.
         */
        System.out.println("\nTest add().");

        System.out.println("Bag 1: ");
        addToBag(bag1, testSet);

        System.out.println("Bag 2: ");
        addToBag(bag2, testSet);

        System.out.println("Bag 1: ");
        showBagStatus(bag1);

        System.out.println("Bag 2:");
        showBagStatus(bag2);

        /**
         * Testing toArray() and printing the results.
         */
        System.out.println("\nTesting toArray().");

        System.out.print("Bag 1: ");
        displayBag(bag1);
        System.out.print("Bag 2: ");
        displayBag(bag2);

        /**
         * Testing getFrequecyOf(T) and printing the results.
         */
        System.out.println("\nTesting getFrequencyOf(t)");

        System.out.println("Bag 1: there is/are " + bag1.getFrequencyOf("c") + " instance(s) of \"c\".");
        System.out.println("Bag 2: there is/are " + bag2.getFrequencyOf("a") + " instance(s) of \"a\".");

        /**
         * Testing the remove methods.
         */
        System.out.println("\nTesting the remove methods.");

        System.out.println("Bag 1: \"" + bag1.remove() + "\" was removed.");
        System.out.println("Bag 1: \"a\" was removed? " + bag1.remove("a"));
        displayBag(bag1);
        
        System.out.println("Bag 2: All \"c's\" removed? " + bag2.removeAllOf("c"));
        displayBag(bag2);

        /**
         * Testing contains().
         */
        System.out.println("\nTesting contains().");

        System.out.println("Bag 1 containes \"c\"? " + bag1.contains("c"));
        System.out.println("Bag 2 containes \"c\"? " + bag2.contains("c"));

        /**
         * Emptying the bag and testing to make sure its empty.
         */
        System.out.println("\nTesting empty().");
        System.out.println("Emptying the bags");

        bag1.empty();
        bag2.empty();

        System.out.println("Bag 1:");
        showBagStatus(bag1);

        System.out.println("Bag 2:");
        showBagStatus(bag2);

        /**
         * Testing isFull().
         */
        System.out.println("\nTesting isFull()");

        System.out.println("\nBag 1:");
        String[] testSet2 = {"a"};
        int i = 0;

        while (i < 50) {
            addToBag(bag1, testSet2);
            i++;
        }

        System.out.println("\nBag 3: (Resizable Array Bag)");
        i = 0;

        while (i < 50) {
            addToBag(bag3, testSet2);
            i++;
        }

    }

    public static void showBagStatus(BagInterface<String> aBag) {
        if (aBag.isEmpty()) {
            System.out.println("The Bag is Empty.");
        } else if (aBag.isFull()) {
            System.out.println("The Bag is Full");
        } else {
            System.out.println("The Bag has Contents");
        }
    }

    public static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains " + aBag.getCurrentSize()
                + " string(s), as follows:");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            System.out.print(bagArray[index] + " ");
        }

        System.out.println();
    }

    public static void addToBag(BagInterface<String> aBag, String[] content) {
        for (String item : content) {
            if (aBag.add(item)) {
                System.out.println("\"" + item + "\" successfully added!");
            } else {
                System.out.println("Add failed!");
                if (aBag.isFull()) {
                    System.out.println("Bag is full!");
                }
            }
        }
    }

    public static void removeFromBag(BagInterface<String> aBag, String aString) {

    }
}
