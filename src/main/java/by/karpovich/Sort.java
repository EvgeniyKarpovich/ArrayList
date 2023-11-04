package by.karpovich;

import java.util.Comparator;

/**
 * This class provides a static method to sort a CustomArrayList using the quicksort algorithm.
 */
public class Sort {

    /**
     * Sorts the elements in the specified CustomArrayList in ascending order according to the specified comparator.
     *
     * @param customArrayList - the CustomArrayList to be sorted
     * @param comparator      - the comparator to determine the order of the elements
     */
    public static <E> void sort(CustomArrayListImpl<E> customArrayList, Comparator<E> comparator) {
        if (customArrayList.getSize() <= 1) {
            return;
        }
        quickSort(customArrayList, 0, customArrayList.getSize() - 1, comparator);
    }

    public static <E extends Comparable<? super E>> void sort(CustomArrayListImpl<E> list) {
        quickSort(list, 0, list.getSize() - 1);
    }

    private static <E extends Comparable<? super E>> void quickSort(CustomArrayListImpl<E> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private static <E> void quickSort(CustomArrayListImpl<E> list, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    private static <E extends Comparable<? super E>> int partition(CustomArrayListImpl<E> list, int low, int high) {
        E pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <E> int partition(CustomArrayListImpl<E> list, int low, int high, Comparator<E> comparator) {
        E pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <E> void swap(CustomArrayListImpl<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private Sort() {
    }
}
