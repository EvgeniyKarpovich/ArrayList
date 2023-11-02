package by.karpovich;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

class SortTest {
    CustomArrayListImpl<Integer> customArrayList;

    @BeforeEach
    void setUp() {
        customArrayList = new CustomArrayListImpl<>();
        customArrayList.add(34);
        customArrayList.add(2);
        customArrayList.add(25);
    }

    @Test
    void sort() {
        Sort.sort(customArrayList, Comparator.naturalOrder());

        assertEquals(customArrayList.get(0), Integer.valueOf(2));
        assertEquals(customArrayList.get(1), Integer.valueOf(25));
        assertEquals(customArrayList.get(2), Integer.valueOf(34));
    }
}