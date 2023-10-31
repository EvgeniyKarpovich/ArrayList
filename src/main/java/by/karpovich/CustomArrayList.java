package by.karpovich;

public interface CustomArrayList<E> {

    boolean add(E element);

    void add(int index, E element);

    E get(int index);

    boolean remove(E element);

    void clear();

    E set(int index, E element);

    public int getSize();
}
