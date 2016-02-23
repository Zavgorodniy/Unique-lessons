package Collections;

import java.util.LinkedList;

public class LinkedListM {

    ListElement firstEl;
    ListElement lastEl;
    int size;

    public LinkedListM() {
        firstEl = null;
        lastEl = null;
        size = 0;
    }

    public LinkedListM(Object el) {
        firstEl = new ListElement(el, null, null);
        lastEl = firstEl;
        size = 1;
    }

    public LinkedListM(Object[] array) {
        init(array);
    }

    public class ListElement {
        Object value;
        ListElement next;
        ListElement prev;

        ListElement(Object value, ListElement prev, ListElement next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(Object el) {
        if(firstEl == null) {
            firstEl = new ListElement(el, null, null);
            lastEl = firstEl;
            size++;
        } else if (lastEl == firstEl){
            lastEl = new ListElement(el, firstEl, null);
            firstEl.next = lastEl;
            size++;
        } else {
            lastEl = new ListElement(el, lastEl, null);
            size++;
        }
    }

    public void add(int index, Object el) {
        ListElement element = null;
        if (index >= 0 && index <= size - 1) {
            element = firstEl;
            for (int i = 1; i <= index; i++) {
                element = element.next;
            }
            element.value = el;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Object get(int index) {
        ListElement element;
        if (index >= 0 && index < size) {
            element = firstEl;
            for (int i = 1; i <= index; i++) {
                element = element.next;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return element.value;
    }

    public boolean remove(Object el) {
        if (size != 0) {
            ListElement element = firstEl;
            for (int i = 0; i < size; i++) {
                if (element.value.equals(el)) {
                    element.prev.next = element.next;
                    return true;
                }
                element = element.next;
            }
        }
        return false;
    }

    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            ListElement element = firstEl;
            for (int i = 0; i <= index; i++) {
                element = element.next;
            }
            element.prev.next = element.next;
        } else {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean sort() {

        if (size > 1) {
            if (size == 0 | size == 1) {
                System.out.println("Nothing to sort");
                return false;
            } else {
                ListElement element = firstEl;

                for (int i = 1; i < size; i++) {
                    checkForCompare(element.value, element.next.value);
                    element = element.next;
                }

                for (int i = size - 1; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        if (((Comparable) element.value).compareTo(element.next.value) == 1) {
                            ListElement tmp = element;
                            element = element.next;
                            element.next = tmp;
                        }
                    }
                }
            }

            System.out.println("Collection sorted: \n" + this.toString());
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Object min() {
        ListElement min = firstEl;

        for (int i = 1; i < size ; i++) {
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

    public void init(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
    }

    private boolean checkForCompare(Object el1, Object el2) {
        if (el1 == null || el2 == null)
            throw new ClassCastException("Can't compare elements. Values contains nulls");
        else if (!el1.getClass().equals(el2.getClass()))
            throw new ClassCastException("Can't compare elements with different classes");
        else if (!(el1 instanceof Comparable) || !(el2 instanceof Comparable))
            throw new ClassCastException("Can't compare elements. No criteria for compare");

        return true;
    }
}
