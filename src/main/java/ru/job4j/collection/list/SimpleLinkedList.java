package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> el = first;
        for (int i = 0; i < index; i++) {
            el = el.next;
        }
        return el.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> el = first;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return el != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                E rsl = el.item;
                el = el.next;

                return rsl;
            }
        };
    }

    public static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
