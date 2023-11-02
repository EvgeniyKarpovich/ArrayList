package by.karpovich;

import java.util.Arrays;

/**
 * Implementation of a custom ArrayList data structure.
 * This class provides methods to add, get, remove, and modify elements in the list.
 * The underlying data is stored in an array.
 *
 * @param <E> the type of elements stored in the list
 */
public class CustomArrayListImpl<E> implements CustomArrayList<E> {

    /**
     * The Array in which the elements are stored
     */
    private Object[] array;
    /**
     * Value of default capacity
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * The size of the list
     */
    private int size = 0;

    /**
     * Creates a new empty list  with a capacity of 10
     */
    public CustomArrayListImpl() {
        this.array = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Creates a new empty list  with a specified capacity of 10
     *
     * @param initialCapacity – the initial capacity of the list
     * @throws IllegalArgumentException – if the specified initial capacity is not  valid
     */
    public CustomArrayListImpl(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = new Object[initialCapacity];
        }
        if (initialCapacity == 0) {
            this.array = new Object[0];
        } else {
            throw new IllegalArgumentException("Incorrect value of capacity");
        }
    }

    /**
     * Adds the specified element the end of the list.
     * If there is not enough space to increase the array
     *
     * @param element - element to be added to this list
     * @return true - if element was added
     */
    @Override
    public boolean add(E element) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = element;

        return true;
    }

    /**
     * Inserts the element in this list  in the specified position.
     * If there is not enough space to increase the array
     *
     * @param index   – index of list  to be added
     * @param element – element to be inserted
     * @throws IndexOutOfBoundsException - if the index is out of bounds
     */
    @Override
    public void add(int index, E element) {
        checkValidityOfIndex(index);
        if (size == array.length) {
            increaseCapacity();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    /**
     * Returns the element at the specified position in the list.
     *
     * @param index - index of element which need to get
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of bounds
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkValidityOfIndex(index);
        return (E) array[index];
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element - element to be removed from this list, if present
     * @return true if this list contained the specified element
     * @throws IndexOutOfBoundsException - if the index is out of bounds
     */
    @Override
    public boolean remove(E element) {
        int position = getIndex(element);

        if (position < 0) {
            return false;
        }
        checkValidityOfIndex(position);

        Object[] newArray = new Object[size - 1];
        for (int i = 0; i < position; i++) {
            newArray[i] = array[i];
        }
        for (int i = position; i < newArray.length; i++) {
            newArray[i] = array[i + 1];
        }
        size--;

        array = newArray;
        return true;
    }

    /**
     * Removes all the elements from this list. The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Replaces the element at the specified position in the list with the specified element.
     *
     * @param element - element to be set
     * @param index   - the index in the array to be set
     * @return true if this list contained the specified element
     * @throws IndexOutOfBoundsException - if the index is out of bounds
     */
    @Override
    public E set(int index, E element) {
        checkValidityOfIndex(index);
        array[index] = element;

        return get(index);
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return returns the number of elements in the list.
     */
    @Override
    public int getSize() {
        return size;
    }

    private void checkValidityOfIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Incorrect value of index");
        }
    }

    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private int getIndex(E element) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "CustomArrayListImpl{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
