package Collections;

/**
 * An object that contains related pairs of keys and values. Cannot contain duplicate keys;
 * each key can relate to only one value.
 * @author Nick
 * @version 1.0b 2016 Feb 17
 */
public class MapM {

    /** Array of entries which contain related pairs {@code (key, value)}
     * @see Entry
     */
    private Entry[] array;

    /** Size of inner array. It doesn't indicate the actual number of elements in the inner array. */
    private int size;

    /** Indicates the index of the last added element.
     * The actual number of elements in array is {@code currentIndex + 1} {@link #size()};
     * -1 is the value for an empty inner array.
     */
    private int currentIndex = -1;

    /** Empty constructor, which sets the standard initial size of the array */
    public MapM() {
        size = 16;
        array = new Entry[size];
        System.out.println("Map initialized with inner array size " + size);
    }

    /** Overloaded constructor with a size parameter for initialization of inner array */
    public MapM(int size) {
        this.size = size;
        array = new Entry[size];
        System.out.println("Map initialized with inner array size " + size);
    }

    /**
     * Adds the relation key - value to the inner array as object {@code Entry(key, value)};
     * if the pair with the same key already exists, it overwrites the value of element.
     * @param key marker for finding the entry pair
     * @param value saved object
     */
    public void add(Object key, Object value) {
        boolean elementAdded = false;

        if (key == null)
            throw new IllegalArgumentException("Can't add element with null key");

        for (int i = 0; i <= currentIndex ; i++) {
            if(!array[i].key.getClass().equals(key.getClass()))
                continue;
            if (array[i].key.equals(key)) {
                array[i].value = value;
                elementAdded = true;
                System.out.println("Element " + array[i].toString() + " replaced");
                break;
            }
        }

        if (!elementAdded && currentIndex < size - 1) {
            array[++currentIndex] = new Entry(key, value);
            System.out.println("Element " + array[currentIndex].toString() + " added");
        } else if (!elementAdded){
            Entry[] tmp = array;
            size += size/2;
            array = new Entry[size];
            currentIndex = -1;
            System.out.println("Rewrite inner array. New size = " + size);

            for (Entry entry: tmp) {
                array[++currentIndex] = entry;
            }
            array[++currentIndex] = new Entry (key, value);
            System.out.println("Element " + array[currentIndex].toString() + " added");
        }
    }

    /**
     * Returns value of entry pair by the key. Returns null, if the key is not found.
     * @param key marker for finding the entry pair
     * @return value of entry pair, or null
     */
    public Object get(Object key) {
        if (key == null)
            throw new IllegalArgumentException("Try not null key");

        for (int i = 0; i <= currentIndex ; i++) {
            if (array[i].key.equals(key)) {
                System.out.println("Element " + array[i].toString());
                return array[i].value;
            }
        }

        System.out.println("No such element to get");
        return null;
    }

    /**
     * Removes entry from inner array by key marker.
     * @param key marker for finding and removing the entry pair
     * @return true, if remove was successful. In different way, returns false
     */
    public boolean remove(Object key) {
        if (key == null)
            throw new IllegalArgumentException("Try not null key");

        for (int i = 0; i <= currentIndex; i++) {
            if (array[i].key.equals(key)) {
                System.out.println("Element " + array[i].toString() + " removed");
                for (int j = i; j < currentIndex; j++)
                    array[j] = array[j + 1];

                currentIndex--;
                return true;
            }
        }

        System.out.println("No such element to remove");
        return false;
    }

    /**
     * Sorts collection of entries by object value, if they are comparable and not null;
     * keys are ignored.
     * Can sort collection in two ways: from min to max value and in opposite way.
     * @param fromMinToMax is boolean parameter, that indicates to sort in native way if it is true;
     *                     if it is false, sorts collection in different way (from max to min)
     * @return true, if sort was successful and false if was not.
     */
    public boolean sort(boolean fromMinToMax) {
        Entry[] sortedArray = array;

        if (size() == 0 | size() == 1) {
            System.out.println("Not enough elements to sort");
            return false;
        }

        for (int i = currentIndex; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                checkForCompare(array[j], array[j + 1]);
                if (((Comparable) sortedArray[j].value).compareTo(sortedArray[j + 1].value) == 1) {
                    Entry tmp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = tmp;
                }
            }
        }

        if (!fromMinToMax)
            reverse();

        array = sortedArray;
        System.out.println("Collection sorted: \n" + this.toString());
        return true;
    }

    /** Reverses collection
     * @return true, if reverse was successful and false if was not.
     */
    public boolean reverse() {
        if (size() == 0 | size() == 1) {
            System.out.println("Not enough elements to reverse");
            return false;
        }

        for (int i = 0, j = currentIndex; i <= currentIndex / 2; i++, j--) {
            Entry tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
        System.out.println("Reverse collection: \n" + this.toString());
        return true;
    }

    /**
     * Finds element from entries with lowest value from values of entries, if they are comparable and not null;
     * keys are ignored.
     * @return entry(key, value) from collection with the lowest value
     */
    public Entry min() {
        Entry min = array[0];
        for (int i = 1; i <= currentIndex ; i++) {
            checkForCompare(min, array[i]);
            if (((Comparable) min.value).compareTo(array[i].value) == 1)
                min = array[i];
        }
        System.out.println("Min element: " + min);
        return min;
    }

    /**
     * Finds element from entries with highest value from values of entries, if they are comparable and not null;
     * keys are ignored.
     * @return entry(key, value) from collection with the highest value
     */
    public Object max() {
        Entry max = array[0];
        for (int i = 1; i <= currentIndex ; i++) {
            checkForCompare(max, array[i]);
            if (((Comparable) max.value).compareTo(array[i].value) == -1)
                max = array[i];
        }

        System.out.println("Max element: " + max);
        return max;
    }

    /** Returns number of elements in collection.
     * It differs from value {@link #size}, that contain a size of inner array.
     * @return number of elements
     */
    public int size() {
        return currentIndex + 1;
    }

    /** method for verifying the conditions for comparison
     * @return true if elements are suitable for comparison
     */
    private boolean checkForCompare(Entry el1, Entry el2) {
        if (el1.value == null || el2.value == null)
            throw new ClassCastException("Can't compare elements. Values contains nulls");
        else if (!el1.value.getClass().equals(el2.value.getClass()))
            throw new ClassCastException("Can't compare elements with different classes");
        else if (!(el1.value instanceof Comparable) || !(el2.value instanceof Comparable))
            throw new ClassCastException("Can't compare elements. No criteria for compare");

        return true;
    }

    /** @return inner array of entry pairs with size, equals to number of elements */
    public Entry[] toArray() {
        Entry[] newArray = new Entry[size()];
        for (int i = 0; i < size(); i++)
            newArray[i] = array[i];
        return newArray;
    }

    /**
     * Returns convenient representation of collection.
     * Uses {@code toString()} method of Entry object
     * @return representation of collection
     */
    public String toString() {
        StringBuilder stringArray = new StringBuilder();

        stringArray.append("{");
        for (int i = 0; i < currentIndex; i++) {
            stringArray.append(array[i].toString());
            stringArray.append(", ");
        }

        stringArray.append(array[currentIndex].toString());
        stringArray.append("}");
        return stringArray.toString();
    }

    /** Encapsulated class, which contains the related pair of key and value */
    private class Entry {
        Object key;
        Object value;

        /**
         * Simple entry constructor.
         * @param key marker for access to value element
         * @param value element
         */
        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Low equals. Comparison for equal only values of entry pairs.
         * @param obj object for comparison
         * @return true, if values of compared pairs are equal
         */
        public boolean lowEquals(Object obj) {
            if (obj == this)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            Entry someEntry = (Entry) obj;
            Object value1 = this.value;
            Object value2 = someEntry.value;

            return value1 != null && value1.equals(value2);
        }

        /**
         * Deep equals. Comparison for equal values and keys.
         * @param obj object for comparison
         * @return true, if values and keys of compared pairs are equal
         */
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            Entry someEntry = (Entry) obj;
            Object key1 = this.key;
            Object key2 = someEntry.key;
            if (key1.equals(key2)) {
                Object value1 = this.value;
                Object value2 = someEntry.value;
                return value1 != null && value1.equals(value2);
            }
            return false;
        }

        /** @return hashcode of entry pair */
        public final int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }

        /** @return convenient representation of entry pair. It differs for different classes */
        public String toString() {
            String keyString = key.toString();
            String valueString;

            if (key.getClass().equals(String.class))
                keyString = "\"" + key + "\"";
            else if (key.getClass().equals(Character.class))
                keyString = "'" + key + "\'";

            if (value != null) {
                valueString = value.toString();
                if (value.getClass().equals(String.class))
                    valueString = "\"" + value + "\"";
                else if (value.getClass().equals(Character.class))
                    valueString = "'" + value + "\'";
            }
            else
                valueString = "null";

            return "[" + keyString + ", " + valueString + "]";
        }
    }
}
