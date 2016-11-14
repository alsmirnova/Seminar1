package seminar1.collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<Item> implements IStack<Item> {

    private static final int DEFAULT_CAPACITY = 4;

    private Item[] elementData;
    private int size;
    private int oldCap, newCap;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.elementData = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(Item item) {
        /* TODO: implement it */
        grow();
        elementData[size] = item;
        size++;
    }

    @Override
    public Item pop() {
        /* TODO: implement it */
        if (size > 0) size--;
        shrink();
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void grow() {
        /**
         * TODO: implement it
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        if (size == elementData.length) {
            oldCap = elementData.length;
            newCap = oldCap + (oldCap >> 1); //увеличение в 1.5 раза
            changeCapacity(newCap);
        }
    }

    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        if (elementData.length>3) {
            if (size <= (elementData.length >> 2)) {
                oldCap = elementData.length;
                if (size == (oldCap >> 2)) {
                    changeCapacity(oldCap >> 1);
                }
            }
        }
    }

    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {

        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public Item next() {
            return elementData[--currentPosition];
        }

    }

    public static void main(String[] args) {
        ArrayStack arr = new ArrayStack();

    }

}
