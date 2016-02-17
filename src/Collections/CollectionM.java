package Collections;

/**
 *
 */
public interface CollectionM {

    void add(Object element);

    boolean set(Object element, int index);

    Object get(int index);

    boolean remove(int index);

    boolean sort(boolean fromMinObjectoMax);

    Object min();

    Object max();

    void init();

}
