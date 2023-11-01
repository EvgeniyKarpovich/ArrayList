package by.karpovich;

import java.util.Comparator;

public class Sort {

    private Sort() {
    }

    public static <E> void sort(CustomArrayListImpl<E> customArrayList, Comparator<E> comparator) {
        quickSortHelper(customArrayList, 0, customArrayList.getSize() - 1, comparator);
    }

    private static <E> void quickSortHelper(CustomArrayListImpl<E> customArrayList, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pivotIndex = partition(customArrayList, low, high, comparator);
            quickSortHelper(customArrayList, low, pivotIndex - 1, comparator);
            quickSortHelper(customArrayList, pivotIndex + 1, high, comparator);
        }
    }

    private static <E> int partition(CustomArrayListImpl<E> customArrayList, int low, int high, Comparator<E> comparator) {
        E pivot = customArrayList.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(customArrayList.get(j), pivot) <= 0) {
                i++;
                swap(customArrayList, i, j);
            }
        }
        swap(customArrayList, i + 1, high);
        return i + 1;
    }

    private static <E> void swap(CustomArrayListImpl<E> customArrayList, int i, int j) {
        E temp = customArrayList.get(i);
        customArrayList.set(i, customArrayList.get(j));
        customArrayList.set(j, temp);
    }
}
