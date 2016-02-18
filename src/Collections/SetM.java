package Collections;

/**
 *
 */
public class SetM{

    private Object[] array;

    public int size;

    public int currentIndex = -1;

    public SetM() {
        size = 10;
        array = new Object[size];
    }

    public SetM(Object[] array) {
        this.array = array;
        size = array.length;
        currentIndex = size - 1;
    }

    public void add(Object element) {
        if (currentIndex < size - 1) {
            array[++currentIndex] = element;
        } else {
            Object[] tmp = array;
            size += size/2;
            array = new Object[size];
            currentIndex = -1;

            System.out.println("log: Rewrite array. New size = " + size);

            for (Object obj: tmp) {
                array[++currentIndex] = obj;
            }
            add(element);
        }
    }

    public boolean set(Object element, Object newElement) {

        for (Object el: array) {
            if (el.equals(element)) {
                el = newElement;
                return true;
            }
        }
        System.out.println("log: element not founded");
        return false;
    }

    public boolean remove(Object element) {
        for (int i = 0; i <= currentIndex; i++) {

            if (array[i].equals(element)) {
                for (int j = i; j < currentIndex; j++) {
                    array[j] = array[j + 1];
                }
                currentIndex--;
                return true;
            }
        }
        System.out.println("log: No such element");
        return false;
    }

    public boolean sort(boolean fromMinToMax) {
        Object[] sortedArray = array;

        if (size == 0){
            System.out.println("log: Empty list");
            return false;
        }
        for (int i = currentIndex; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(!sortedArray[i].getClass().equals(sortedArray[j].getClass()) || !(sortedArray[i] instanceof Comparable && sortedArray[j] instanceof Comparable)) {
                    System.out.println("log: Can't compare elements");
                    throw new ClassCastException();
                }
                if(fromMinToMax) {
                    if (((Comparable) sortedArray[j]).compareTo(sortedArray[j + 1]) == 1) {
                        Object tmp = sortedArray[j];
                        sortedArray[j] = sortedArray[j + 1];
                        sortedArray[j + 1] = tmp;
                    }
                } else {
                    if (((Comparable) sortedArray[j]).compareTo(sortedArray[j + 1]) == -1) {
                        Object tmp = sortedArray[j];
                        sortedArray[j] = sortedArray[j + 1];
                        sortedArray[j + 1] = tmp;
                    }
                }
            }
        }

        array = sortedArray;
        return true;
    }

    public void reverse() {
        int j = currentIndex;
        for (int i = 0; i <= currentIndex / 2; i++, j--) {
            Object tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
    }

    public Object min() {
        Object min = array[0];

        for (int i = 1; i <= currentIndex ; i++) {
            if(!min.getClass().equals(array[i].getClass()) || !(min instanceof Comparable && array[i] instanceof Comparable)) {
                System.out.println("log: Can't compare elements");
                throw new ClassCastException();
            }
            if (((Comparable) min).compareTo(array[i]) == 1) {
                min = array[i];
            }
        }

        return min;
    }

    public Object max() {
        Object max = array[0];

        for (int i = 1; i <= currentIndex ; i++) {
            if(!max.getClass().equals(array[i].getClass()) || !(max instanceof Comparable && array[i] instanceof Comparable)) {
                System.out.println("log: Can't compare elements");
                throw new ClassCastException();
            }
            if (((Comparable) max).compareTo(array[i]) == -1) {
                max = array[i];
            }
        }

        return max;
    }
}
