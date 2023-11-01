package by.karpovich;

/**
 * This interface represents a custom ArrayList.
 * This interface provides methods to add, get, remove, and modify elements in the list.
 * The underlying data is stored in an array.
 *
 * @param <E> the type of elements stored in the list
 */
public interface CustomArrayList<E> {
    /**
     * Adds the specified element the end of the list.
     */
    boolean add(E element);

    /**
     * Inserts the element in this list  in the specified position.
     */
    void add(int index, E element);

    /**
     * Returns the element at the specified position in the list.
     */
    E get(int index);

    /**
     * Removes the first occurrence of the specified element from the list.
     */
    boolean remove(E element);

    /**
     * Removes all the elements from this list. The list will be empty after this call returns.
     */
    void clear();

    /**
     * Replaces the element at the specified position in the list with the specified element.
     */
    E set(int index, E element);

    /**
     * Returns the number of elements in the list.
     */
    int getSize();
}
