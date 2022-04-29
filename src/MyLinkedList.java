import java.util.LinkedList;

public class MyLinkedList<E> implements MyList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
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
    public boolean add(E e) {
        if (last != null) {
            Node<E> newNode = new Node<>(e, last, null);
            last.next = newNode;
            last = newNode;
            size++;
        } else {
            Node<E> newNode = new Node<>(e, null, null);
            first = newNode;
            last = newNode;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int objectIndex = indexOf(o);
        if (objectIndex >= 0) {
            E removed = remove(objectIndex);
            if (removed != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private Node<E> getNode(int index) {
        if ((index < 0) || (index > (size-1))) {
            throw new IndexOutOfBoundsException();
        }

        if ( (size / 2) >= index ) {

            Node<E> curNode = first;
            int counter = 0;
            while (counter < index) {
                curNode = curNode.next;
                counter++;
            }
            return curNode;

        } else {

            Node<E> curNode = last;
            int counter = size-1;
            while (counter > index) {
                curNode = curNode.prev;
                counter--;
            }
            return curNode;

        }

    }

    @Override
    public E get(int index) {
        return getNode(index).itemData;
    }

    @Override
    public E remove(int index) {
        Node<E> nodeToDelete = getNode(index);
        nodeToDelete.prev.next = nodeToDelete.next;
        nodeToDelete.next.prev = nodeToDelete.prev;
        size--;
        return nodeToDelete.itemData;
    }

    @Override
    public int indexOf(Object o) {

        Node<E> curNode = first;
        int objectIndex = 0;

        while (curNode != null) {
            if (curNode.itemData.equals(o)) {
                return objectIndex;
            } else {
                curNode = curNode.next;
                objectIndex++;
            }
        }
        return -1;
    }

    private static class Node<E> {
        E itemData;
        Node<E> prev;
        Node<E> next;

        public Node(E itemData, Node<E> prev, Node<E> next) {
            this.itemData = itemData;
            this.prev = prev;
            this.next = next;
        }
    }
}
