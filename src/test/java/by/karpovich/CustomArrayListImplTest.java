package by.karpovich;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomArrayListImplTest {

    private CustomArrayListImpl<String> customArrayList;

    @Before
    public void setUp() {
        customArrayList = new CustomArrayListImpl<>();
        customArrayList.add("element");
        customArrayList.add("element2");
        customArrayList.add("element3");
    }

    @Test
    public void testAdd() {
        boolean added = customArrayList.add("newElement4");

        assertEquals("element", customArrayList.get(0));
        assertEquals("element2", customArrayList.get(1));
        assertEquals("element3", customArrayList.get(2));
        assertEquals("newElement4", customArrayList.get(3));

        assertTrue(added);

        assertEquals(4, customArrayList.getSize());
    }

    @Test
    public void testAddByIndex() {
        customArrayList.add(1, "newElement2");

        assertEquals("element", customArrayList.get(0));
        assertEquals("newElement2", customArrayList.get(1));
        assertEquals("element2", customArrayList.get(2));
        assertEquals("element3", customArrayList.get(3));

        assertEquals(4, customArrayList.getSize());
    }

    @Test
    public void testGet() {
        assertEquals("element2", customArrayList.get(1));
    }

    @Test
    public void testRemove() {
        boolean removed = customArrayList.remove("element");

        assertTrue(removed);
        assertEquals(2, customArrayList.getSize());
    }

    @Test
    public void testClear() {
        customArrayList.clear();

        assertEquals(0, customArrayList.getSize());
    }

    @Test
    public void testSet() {
        customArrayList.set(1, "newElement2");

        assertEquals("newElement2", customArrayList.get(1));
    }

    @Test
    public void testGetSize() {
        assertEquals(3, customArrayList.getSize());
    }

    @Test
    public void throwIndexOutOfBoundsExceptionInMethodAdd() {
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.add(200, "newElement8"));

        assertEquals(3, customArrayList.getSize());
    }

    @Test
    public void throwIndexOutOfBoundsExceptionInMethodGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.get(100));
    }

    @Test
    public void throwIndexOutOfBoundsExceptionInMethodSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.set(200, "newElement200"));

        assertEquals(3, customArrayList.getSize());
    }
}