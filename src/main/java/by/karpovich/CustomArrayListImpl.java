package by.karpovich;

import java.util.Arrays;

public class CustomArrayListImpl<E> implements CustomArrayList<E> {

    private Object[] arrayOfElements;
    private final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public CustomArrayListImpl() {
        this.arrayOfElements = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayListImpl(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Incorrect value of capacity");
        }
        if (initialCapacity > 0) {
            this.arrayOfElements = new Object[initialCapacity];
        } else {
            this.arrayOfElements = new Object[0];
        }
    }

    @Override
    public void add(E element) {
        if (size == arrayOfElements.length) {
            increaseCapacity();
        }
        arrayOfElements[size] = element;
        size++;
    }

    @Override
    public void add(int index, E element) {
        checkValidityOfIndex(index);
        if (size == arrayOfElements.length) {
            increaseCapacity();
        }
        for (int i = size - 1; i >= index; i--) {
            arrayOfElements[i + 1] = arrayOfElements[i];
        }
        arrayOfElements[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        checkValidityOfIndex(index);
        return (E) arrayOfElements[index];
    }

    @Override
    public void remove(E element) {
        int ind = 0;
        for (int i = 0; i < size; i++) {
            if (arrayOfElements[i].equals(element)) {
                ind = i;
                break;
            }
        }
        if (ind != 0) {

        }

    }

    @Override
    public void clear() {
        arrayOfElements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void set(int index, E element) {
        checkValidityOfIndex(index);
        arrayOfElements[index] = element;
    }

    private void checkValidityOfIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Incorrect value of index");
        }
    }

    private void increaseCapacity() {
        int newCapacity = arrayOfElements.length * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = arrayOfElements[i];
        }
        arrayOfElements = newArray;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "CustomArrayListImpl{" +
                "arrayOfElements=" + Arrays.toString(arrayOfElements) +
                ", DEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                ", size=" + size +
                '}';
    }
}
