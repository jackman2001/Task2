package ua.nure.lytovchenko.task2.part1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl<E> implements Array<E> {
    private E[] array = (E[]) new Object[5];
    private int length = 5;
    private int pointer;
    private boolean removed = true;

    @Override
    public void add(E element) {
        if (pointer + 1 == length) {
            length *= 2;
            E[] tempArray = (E[]) new Object[length];
            System.arraycopy(array, 0, tempArray, 0, array.length);
            array = tempArray;
        }
        array[pointer++] = element;
    }

    @Override
    public void set(int index, E element) {
        array[index] = element;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, pointer - index);
        pointer--;
    }

    @Override
    public void clear() {
        array = (E[])new Object[5];
        pointer = 0;
        length = 5;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public String toString() {
        if (pointer == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < pointer; i++) {
            sb.append(array[i]).append(", ");
        }
        return sb.substring(0, sb.length() - 2) + "]";
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    class IteratorImpl<E> implements Iterator<E> {
        private int current = -1;

        @Override
        public boolean hasNext() {
            return get(current + 1) != null && current < pointer;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            removed = false;
            return (E) get(++current);
        }

        @Override
        public void remove() {
            if (!removed) {
                ArrayImpl.this.remove(current);
                current--;
                removed = true;
            } else {
                throw new IllegalStateException();
            }
        }
    }


}
