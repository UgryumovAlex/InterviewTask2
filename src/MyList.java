
public interface MyList<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean add(E e);

    boolean remove(Object o);

    void clear();

    E get(int index);

    E remove(int index);

    int indexOf(Object o);

}
