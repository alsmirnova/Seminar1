package seminar1.collections;

import java.util.Iterator;

public class LinkedStack<Item> implements IStack<Item> {

     private Node<Item> head;
    private int size;

    @Override
    public void push(Item item) {
        /* TODO: implement it */

        head = new Node(item, head);
        size++;
    }

    @Override
    public Item pop() {
        /* TODO: implement it */
        if (size > 0) {
            head = head.next;
            size--;
        }
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

    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {
        Node<Item> current = head;


        @Override
        public boolean hasNext() {
            /* TODO: implement it */
            if (current != null) return true;
            return false;
        }

        @Override
        public Item next() {
            /* TODO: implement it */
            if (size!=0) {
                Item item = current.item;
                current = current.next;
                return item;
            }
        return null;}

    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
