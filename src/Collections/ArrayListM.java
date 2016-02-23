package Collections;

public class ArrayListM<T> {

    private T[] array;

    public int size;

    public int currentIndex = -1;

    public ArrayListM() {
        size = 10;
        array = (T[]) new Object[size];
    }

    public ArrayListM(int size) {
        this.size = size;
        array = (T[]) new Object[size];
    }

    public ArrayListM(T[] array) {
        this.array = array;
        size = array.length;
        currentIndex = size - 1;
    }

    public void add(T element) {
        if (currentIndex < size - 1) {
            array[++currentIndex] = element;
        } else {
            T[] tmp = array;
            size += size/2;
            array = (T[]) new Object[size];
            currentIndex = -1;

            System.out.println("log: Rewrite array. New size = " + size);

            for (T obj: tmp) {
                array[++currentIndex] = obj;
            }
            add(element);
        }
    }

    public void add(T element, int index) {
//
//        if (currentIndex < size - 1) {
//            array[++currentIndex] = element;
//        } else {
//            Object[] tmp = array;
//            size += size/2;
//            array = new Object[size];
//            currentIndex = -1;
//
//            System.out.println("log: Rewrite array. New size = " + size);
//
//            for (Object obj: tmp) {
//                array[++currentIndex] = obj;
//            }
//            add(element);
//        }
    }

    public boolean set(T element, int index) {
        if (index > currentIndex) {
            System.out.println("log: Can't set element with index " + index + ". Current max index is " + currentIndex);
            return false;
        }

        array[index] = element;
        return true;
    }

    public T get(int index) {
        if (index > currentIndex) {
            System.out.println("log: Can't get element with index " + index + ". Current max index is " + currentIndex);
            return null;
        }
        return array[index];
    }

    public boolean remove(int index) {
        if (index > currentIndex) {
            System.out.println("log: Can't remove element with index " + index + ". Current max index is " + currentIndex);
            return false;
        }

        for (int i = index; i < currentIndex; i++)
            array[i] = array[i + 1];

        currentIndex--;
        return true;
    }

    public boolean sort(boolean fromMinToMax) {
        T[] sortedArray = array;

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
                        T tmp = sortedArray[j];
                        sortedArray[j] = sortedArray[j + 1];
                        sortedArray[j + 1] = tmp;
                    }
                } else {
                    if (((Comparable) sortedArray[j]).compareTo(sortedArray[j + 1]) == -1) {
                        T tmp = sortedArray[j];
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
            T tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
    }

    public T min() {
        T min = array[0];

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

    public T max() {
        T max = array[0];

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

    public int size() {
        return currentIndex + 1;
    }

    @Override
    public String toString() {
        StringBuilder stringArray = new StringBuilder();

        stringArray.append("{");
        for (int i = 0; i < currentIndex; i++) {
            stringArray.append("[" + array[i] + "], ");
        }
        stringArray.append("[" + array[currentIndex].toString() + "]}");

        return stringArray.toString();
    }
}
