package main;

import java.util.Arrays;
import java.util.Collection;

public class SimpleListImpl implements SimpleList {

    private final int MIN_ARRAY_SIZE = 16;
    private Object[] arr = new Object[MIN_ARRAY_SIZE];
    private int listSize = 0;

    @Override
    public Object get(int index) {
          if (index < listSize && index >= 0) {
            return arr[index];}
            throw new IndexOutOfBoundsException();

    }

    @Override
    public Object set(int index, Object element) {
        if (index >= listSize && index < 0) {
            throw new IndexOutOfBoundsException();
        }
            Object previousEl = arr[index];
            arr[index] = element;
            return previousEl;

    }

    @Override
    public void add(int index, Object element) {
        if (index > listSize && index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            // TODO else clause is redundant
            Object[] temp = arr;
            if (listSize == arr.length) {
                arr = new Object[temp.length + MIN_ARRAY_SIZE];
            }
                System.arraycopy(temp, 0, arr, 0, index);
                System.arraycopy(temp, index, arr, index + 1, listSize);
                arr[index] = element;
            listSize++;
        }
    }

    @Override
    public Object remove(int index) {
        if (index <= size() && index >= 0) {
            Object previousEl = arr[index];
            // TODO the implementation is wrong
            // for each remove call - If arr is not ready to be shrinked,
            // but you're still calling System.arraycopy(..) operation twice
            // you just need to copy elements AFTER the index in such case
            Object[] temp = arr;
            if (size() <= (arr.length - MIN_ARRAY_SIZE)) {
                arr = new Object[arr.length - MIN_ARRAY_SIZE];
            }
            System.arraycopy(temp, 0, arr, 0, index);
            int afterI = temp.length - index - 1;
            System.arraycopy(temp, index + 1, arr, index, afterI);
            listSize--;
            return previousEl;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return (listSize == 0);
        // TODO empty line - formatting
    }

    @Override
    public boolean add(Object o) {
        if (listSize == arr.length) {
            Object[] temp = arr;
            arr = new Object[temp.length + MIN_ARRAY_SIZE];
            System.arraycopy(temp, 0, arr, 0, temp.length);
        }
        arr[listSize] = o;
        listSize++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < listSize; i++) {
            if (o.equals(arr[i])) {
                // TODO the implementation is wrong
                // for each remove call - If arr is not ready to be shrinked,
                // but you're still calling System.arraycopy(..) operation twice
                // you just need to copy elements AFTER the removed element in such case
                Object[] temp = arr;
                if (size() <= (arr.length - MIN_ARRAY_SIZE)) {
                    arr = new Object[arr.length - MIN_ARRAY_SIZE];
                }
                System.arraycopy(temp, 0, arr, 0, i);
                int afterI = temp.length - i - 1;
                System.arraycopy(temp, i + 1, arr, i, afterI);
                listSize--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        arr = new Object[MIN_ARRAY_SIZE];
        listSize = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < listSize; i++) {
            if (o.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(arr, 0, size());
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int counter = 0;
        for (Object o : c) {
            if (contains(o)) {
                counter++;
            }
        }
        return counter == c.size();
    }

    @Override
    public boolean addAll(Collection<?> c) {
        boolean wasChanged = false;
        for (Object o : c) {
            if (add(o)) {
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean wasChanged = false;
        for (Object o : c) {
            if (remove(o)) {
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean wasChanged = false;
        for (Object o : c) {
            if (!contains(o)) {
                remove(o);
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < listSize; i++) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }
}
