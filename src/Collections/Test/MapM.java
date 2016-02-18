package Collections.Test;

public class MapM {

    private Entry[] array;

    public int size;

    public int currentIndex = -1;

    public MapM() {
        size = 10;
        array = new Entry[size];
    }

    public MapM(int size) {
        this.size = size;
        array = new Entry[size];
    }

    public void add(Object key, Object value) {
        boolean elementAdded = false;

        for (int i = 0; i <= currentIndex ; i++) {
            if (array[i].key.toString().equals(key.toString())) {
                array[i].value = value;
                elementAdded = true;
                break;
            }
        }

        if (!elementAdded && currentIndex < size - 1) {
            array[++currentIndex] = new Entry(key, value);
        } else if (!elementAdded){
            Entry[] tmp = array;
            size += size/2;
            array = new Entry[size];
            currentIndex = -1;
            System.out.println("log: Rewrite array. New size = " + size);

            for (Entry entry: tmp) {
                array[++currentIndex] = entry;
            }
            array[++currentIndex] = new Entry (key, value);
        }
    }

    public Object get(Object key) {
        for (int i = 0; i <= currentIndex ; i++) {
            if (array[i].key.toString().equals(key.toString())) {
                return array[i].value;
            }
        }
        System.out.println("log: No such element");
        return null;
    }

    public boolean remove(Object key) {
        for (int i = 0; i <= currentIndex; i++) {

            if (array[i].key.toString().equals(key.toString())) {
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
        Entry[] sortedArray = array;

        if (size == 0){
            System.out.println("log: Empty list");
            return false;
        }
        for (int i = currentIndex; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(!sortedArray[i].value.getClass().equals(sortedArray[j].value.getClass()) || !(sortedArray[i].value instanceof Comparable && sortedArray[j].value instanceof Comparable)) {
                    System.out.println("log: Can't compare elements");
                    return false;
                }
                if(fromMinToMax) {
                    if (((Comparable) sortedArray[j].value).compareTo(sortedArray[j + 1].value) == 1) {
                        Entry tmp = sortedArray[j];
                        sortedArray[j] = sortedArray[j + 1];
                        sortedArray[j + 1] = tmp;
                    }
                } else {
                    if (((Comparable) sortedArray[j].value).compareTo(sortedArray[j + 1].value) == -1) {
                        Entry tmp = sortedArray[j];
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
            Entry tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
    }

    public Entry min() {
        Entry min = array[0];

        for (int i = 1; i <= currentIndex ; i++) {
            if(!min.getClass().equals(array[i].value.getClass()) || !(min instanceof Comparable && array[i].value instanceof Comparable)) {
                System.out.println("log: Can't compare elements");
                throw new ClassCastException();
            }
            if (((Comparable) min.value).compareTo(array[i].value) == 1) {
                min = array[i];
            }
        }

        return min;
    }

    public Object max() {
        Entry max = array[0];

        for (int i = 1; i <= currentIndex ; i++) {
            if(!max.getClass().equals(array[i].value.getClass()) || !(max instanceof Comparable && array[i].value instanceof Comparable)) {
                System.out.println("log: Can't compare elements");
                throw new ClassCastException();
            }
            if (((Comparable) max.value).compareTo(array[i].value) == -1) {
                max = array[i];
            }
        }

        return max;
    }

    @Override
    public String toString() {
        StringBuilder stringArray = new StringBuilder();

        stringArray.append("{");
        for (int i = 0; i < currentIndex; i++) {
            stringArray.append("[" + array[i].key.toString() + ", " + array[i].value.toString() + "], ");
        }
        stringArray.append("[" + array[currentIndex].key.toString() + ", " + array[currentIndex].value.toString() + "]}");

        return stringArray.toString();
    }

    private class Entry {
        Object key;
        Object value;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

//        public boolean equals(Object obj) {
//            if (!(obj instanceof Entry))
//                return false;
//
//            Entry someEntry = (Entry) obj;
//            Object key1 = this.key;
//            Object key2 = someEntry.key;
//            if (key1 == key2 || (key1 != null && key1.equals(key2))) {
//                Object value1 = this.value;
//                Object value2 = someEntry.value;
//                if (value1 == value2 || (value1 != null && value1.equals(value2)))
//                    return true;
//            }
//            return false;
//        }
//
//        public final int hashCode() {
//            return key.hashCode() + value.hashCode();
//        }

        public String toString() {
            return "[" + key.toString() + ", " + value.toString() + "]";
        }
    }
}
