
public class MyArrayList<E> implements MyList<E> {

    private static int DEFAULT_SIZE = 3;
    private static float GROW_SIZE = 1.5f;

    private Object[] storage;

    private int size;

    public MyArrayList() {
        this.storage = new Object[DEFAULT_SIZE];
    }

    private void growStorage() {
        if (size == storage.length) {
            int newSize = (int) (storage.length * GROW_SIZE);
            Object[] newStorage = new Object[newSize];
            System.arraycopy(storage, 0, newStorage, 0, size);
            storage = newStorage;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        return (indexOf(o) >= 0);
    }

    @Override
    public boolean add(Object o) {
        storage[size] = o;
        size++;
        growStorage();
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int objectIndex = indexOf(o);

        if (objectIndex >= 0) {
            E deletedItem = remove(objectIndex);
            if (deletedItem != null ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        if (size > 0) {
            storage = new Object[DEFAULT_SIZE];
            size = 0;
        }
    }

    @Override
    public E get(int index) {
        if ((index < 0) || (index > (size-1))) {
            throw new IndexOutOfBoundsException();
        }

        return (E)storage[index];
    }

    @Override
    public E remove(int index) {

        if ((index < 0) || (index > (size-1))) {
            throw new IndexOutOfBoundsException();
        }

        E item = (E) storage[index];

        if (index == (size-1)) {
            storage[index] = null;
            size--;

        } else  {
            Object[] newStorage = new Object[storage.length];

            if (index == 0 ) {
                System.arraycopy(storage, 1, newStorage, 0, size-1);
            } else {
                System.arraycopy(storage, 0, newStorage, 0, index); //Сохраняем левую часть
                System.arraycopy(storage, index+1, newStorage, index, (size-1)-index); //Сохраняем правую часть
            }

            storage = newStorage;
            size--;
        }
        return item;
    }

    @Override
    public int indexOf(Object o) {

        for (int i = 0; i < size; i++) {
            if (o.equals(storage[i])) {
                return i;
            }
        }
        return -1;
    }
}
