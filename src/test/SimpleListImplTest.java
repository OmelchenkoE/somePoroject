package test;

import main.SimpleListImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class SimpleListImplTest {
    SimpleListImpl target = new SimpleListImpl();
    Object o = new Object();

    @Test
    public void testGetAndSet() {
        target.add(o);
        target.set(0, o);
        assertEquals(o, target.get(0));
    }

    @Test
    public void testAddAndGet() {
        target.add(o);
        target.add(0, o);
        assertEquals(o, target.get(0));
    }

    @Test
    public void testRemove() {
        target.add(o);
        target.add("1");
        target.remove(0);
        target.remove("1");
        assertTrue(target.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, target.size());
    }

    @Test
    public void testIsEmptyTrue() {
        assertTrue(target.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        target.add(o);
        assertFalse(target.isEmpty());
    }

    @Test
    public void testClear() {
        target.add(o);
        target.clear();
        assertFalse(target.contains(o));
    }

    @Test
    public void testContains() {
        target.add(o);
        assertTrue(target.contains(o));

    }

    @Test
    public void testToArray() {
        Object[] testArr = new Object[16];
        testArr[0] = o;
        target.add(o);
        assertEquals(testArr, target.toArray());
    }

    @Test
    public void testContainsAll() {
        target.add(o);
        ArrayList list = new ArrayList();
        list.add(o);
        assertTrue(target.containsAll(list));
    }

    @Test
    public void testAddAll() {
        ArrayList list = new ArrayList();
        list.add(o);
        assertTrue(target.addAll(list));
    }

    @Test
    public void testRemoveAll() {
        target.add(o);
        ArrayList list = new ArrayList();
        list.add(o);
        assertTrue(target.removeAll(list));

    }

    @Test
    public void testRetainAll() {
        ArrayList list = new ArrayList();
        list.add(o);
        list.add(1);
        target.add(o);
        assertTrue(target.retainAll(list));
    }

    @Test
    public void testIndexOf() {
        target.add(o);
        assertEquals(0, target.indexOf(o));
    }

    @Test
    public void testLastIndexOf() {
        target.add(o);
        assertEquals(0, target.indexOf(o));
    }
}