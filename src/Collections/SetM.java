package Collections;

public class SetM<T> {

    private T[] array;

    public int size;

    public int currentIndex = -1;

    public SetM() {
        size = 10;
        array = (T[]) new Object[size];
    }

    public SetM(T[] array) {
        for (T el: array) {
            add(el);
        }
        size = array.length;
        currentIndex = size - 1;
    }

    public boolean add(T element) {
        for (int i = 0; i <= currentIndex; i++) {
            if (element.equals(array[i]))
                return false;
        }
        if (currentIndex < size - 1) {
            array[++currentIndex] = element;
        } else {
            T[] tmp = array;
            size += size/2;
            array = (T[]) new Object[size];
            currentIndex = -1;

            System.out.println("Rewrite array. New size = " + size);

            for (T obj: tmp)
                array[++currentIndex] = obj;

            add(element);
        }
        return true;
    }

    public boolean set(T element, T newElement) {
        for (Object el: array) {
            if (el.equals(element)) {
                el = newElement;
                return true;
            }
        }
        System.out.println("No such element");
        return false;
    }

    public T get(T element) {
        for (T el: array) {
            if (el.equals(element)) {
                return el;
            }
        }
        System.out.println("No such element");
        return null;
    }

    public boolean remove(T element) {
        for (int i = 0; i <= currentIndex; i++) {

            if (array[i].equals(element)) {
                for (int j = i; j < currentIndex; j++)
                    array[j] = array[j + 1];
                currentIndex--;
                return true;
            }
        }
        System.out.println("No such element");
        return false;
    }

    public boolean sort(boolean fromMinToMax) {
        T[] sortedArray = array;

        if (size() == 0 | size() == 1) {
            System.out.println("Nothing to sort");
            return false;
        }

        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                checkForCompare(array[j], array[j + 1]);
                if (((Comparable) sortedArray[j]).compareTo(sortedArray[j + 1]) == 1) {
                    T tmp = sortedArray[j];
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

    public void reverse() {
        int j = currentIndex;
        for (int i = 0; i <= currentIndex / 2; i++, j--) {
            T tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
        System.out.println("Reverse collection: \n" + this.toString());
    }

    public T min() {
        T min = array[0];

        for (int i = 1; i <= currentIndex ; i++) {
            checkForCompare(min, array[i]);
            if (((Comparable) min).compareTo(array[i]) == 1)
                min = array[i];
        }
        System.out.println("Min element: " + min);
        return min;
    }

    public T max() {
        T max = array[0];

        for (int i = 1; i <= currentIndex ; i++) {
            checkForCompare(max, array[i]);
            if (((Comparable) max).compareTo(array[i]) == 1)
                max = array[i];
        }
        System.out.println("Max element: " + max);
        return max;
    }

    public int size() {
        return currentIndex + 1;
    }

    private boolean checkForCompare(T el1, T el2) {
        if (el1 == null || el2 == null)
            throw new ClassCastException("Can't compare elements. Values contains nulls");
        else if (!el1.getClass().equals(el2.getClass()))
            throw new ClassCastException("Can't compare elements with different classes");
        else if (!(el1 instanceof Comparable) || !(el2 instanceof Comparable))
            throw new ClassCastException("Can't compare elements. No criteria for compare");

        return true;
    }
}
