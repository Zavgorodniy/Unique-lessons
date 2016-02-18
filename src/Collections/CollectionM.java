package Collections;

/**
 *
 */
public interface CollectionM {

    void add(Object element);

    void add(Object element, int index);

    boolean set(Object element, int index);

    Object get(int index);

    boolean remove(int index);

    boolean sort(boolean fromMinObjectoMax);

    void reverse();

    Object min();

    Object max();

}
