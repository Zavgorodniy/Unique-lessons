package Collections;

import java.util.ArrayList;

/**
 *
 */
public class ArrayListM<T> implements CollectionM {

    ArrayList list = new ArrayList();

    private Object[] array;

    public int size;

    public int currentIndex = -1;

    public ArrayListM() {
        size = 10;
        array = new Object[size];
    }

    public ArrayListM(int size) {
        this.size = size;
        array = new Object[size];
    }

    public ArrayListM(T[] array) {
        this.array = array;
        size = array.length;
        currentIndex = size - 1;
    }

    @Override
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

    @Override
    public boolean set(Object element, int index) {
        if (index > currentIndex) {
            System.out.println("log: Can't set element with index " + index + ". Current max index is " + currentIndex);
            return false;
        }

        array[index] = element;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index > currentIndex) {
            System.out.println("log: Can't get element with index " + index + ". Current max index is " + currentIndex);
            return null;
        }
        return array[index];
    }

    @Override
    public boolean remove(int index) {
        if (index > currentIndex) {
            System.out.println("log: Can't remove element with index " + index + ". Current max index is " + currentIndex);
            return false;
        }

        for (int i = index; i < currentIndex; i++) {
            array[i] = array[i + 1];
        }

        currentIndex--;
        return false;
    }

    @Override
    public boolean sort(boolean fromMinToMax) {

        for (int i = 0; i < currentIndex; i++) {
            if (array[i] instanceof Number) {
                for (int j = array.length - 1 ; j > 0 ; j--){
                    for(int k = 0 ; k < i ; k++){
                        if(Double.parseDouble(array[k].toString()) > Double.parseDouble(array[k + 1].toString())){
                            Object tmp = array[k];
                            array[k] = array[k + 1];
                            array[k + 1] = tmp;
                        }
                    }
                }
            } else if (!array[i].getClass().equals(array[i + 1].getClass())) {
                System.out.println("log: Can't compare " + array[i].getClass() + " and " + array[i + 1].getClass());
                return false;
            } else {
                System.out.println("log: Can't compare different non numerical classes");
            }
        }

        for (int i = 0; i < currentIndex; i++) {

        }
        return true;
    }

    @Override
    public Object min() {
        return null;
    }

    @Override
    public Object max() {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public String toString() {
        StringBuilder stringArray = new StringBuilder();

        stringArray.append("{");
        for (int i = 0; i < currentIndex; i++) {
            stringArray.append("[" + array[i] + "], ");
        }
        stringArray.append("[" + array[currentIndex] + "]}");

        return stringArray.toString();
    }
}
