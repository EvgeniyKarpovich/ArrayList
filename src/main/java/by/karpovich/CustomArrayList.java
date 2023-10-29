package by.karpovich;

public interface CustomArrayList<E> {

    void add(E element);

    void add(int index, E element);

    E get(int index);

    void remove(E element);

    void clear();

    void set(int index, E element);
}
